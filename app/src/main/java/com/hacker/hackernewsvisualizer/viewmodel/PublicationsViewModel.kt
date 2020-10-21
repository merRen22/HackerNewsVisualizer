package com.hacker.hackernewsvisualizer.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hacker.hackernewsvisualizer.R
import com.hacker.hackernewsvisualizer.data.api.Result
import com.hacker.hackernewsvisualizer.data.model.Blacklisted
import com.hacker.hackernewsvisualizer.data.model.Publication
import com.hacker.hackernewsvisualizer.data.model.PublicationsResult
import com.hacker.hackernewsvisualizer.data.repository.BlacklistedRepository
import com.hacker.hackernewsvisualizer.data.repository.PublicationsRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class PublicationsViewModel @Inject constructor(
    private val publicationRepository: PublicationsRepository,
    private val blacklistedRepository: BlacklistedRepository
) : ViewModel()  {

    var mSelectedPublication: Publication?=null

    //<editor-fold desc="GET CLAIMS">
    private val _publicationsResult = MutableLiveData<PublicationsResult>()
    val publicationsResult: LiveData<PublicationsResult> = _publicationsResult
    fun getPublications() {
        viewModelScope.launch {
            runCatching {
                publicationRepository.getPublications()
            }.onSuccess { result ->
                if (result is Result.Success) {
                    /*
                    Add all publications to local db
                     */
                    publicationRepository.removeAllLocal()
                    result.data.forEach {
                        publicationRepository.insertToLocal(it)
                    }

                    runCatching {
                        blacklistedRepository.getLocalPublications()
                    }.onSuccess {
                        _publicationsResult.value =
                            PublicationsResult(
                                successPublications = if(it.isEmpty()) result.data.toList() else
                                result.data.toList().filter {publication ->
                                    !it.contains(Blacklisted(publication.objectID))
                                }
                            )
                    }
                } else {
                    getLocalPublications()
                    _publicationsResult.value =
                        PublicationsResult(errorPublications = R.string.connection_error_detail)
                }
            }
        }
    }

    private fun getLocalPublications() {
        viewModelScope.launch {
            runCatching {
                publicationRepository.getLocalPublications()
            }.onSuccess { result ->
                if (result.isNotEmpty()) {
                    runCatching {
                        blacklistedRepository.getLocalPublications()
                    }.onSuccess {
                        _publicationsResult.value =
                            PublicationsResult(
                                successPublications = if(it.isEmpty()) result else
                                    result.filter {publication ->
                                        !it.contains(Blacklisted(publication.objectID))
                                    }
                            )
                    }
                } else {
                    _publicationsResult.value =
                        PublicationsResult(errorPublications = R.string.publications_local_error)
                }
            }
        }
    }
    //</editor-fold>

    //<editor-fold desc="BLACKLISTED">
    fun insertBlacklisted(publication: Publication) {
        viewModelScope.launch {
            runCatching {
                blacklistedRepository.insertToLocal(publication.objectID!!)
            }
        }
    }
    //</editor-fold>

}