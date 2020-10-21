package com.hacker.hackernewsvisualizer.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.*
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.hacker.hackernewsvisualizer.databinding.FragmentPublicationDetailBinding
import com.hacker.hackernewsvisualizer.viewmodel.PublicationsViewModel
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_publication_detail.*
import kotlinx.android.synthetic.main.item_no_internet.view.*
import javax.inject.Inject


class PublicationDetailFragment: DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val publicationsViewModel: PublicationsViewModel by activityViewModels { viewModelFactory }

    private lateinit var binding: FragmentPublicationDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPublicationDetailBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var webViewSuccess = true

        webview.settings.javaScriptEnabled = true

        publicationsViewModel.mSelectedPublication?.let {
            webview.loadUrl(it.url?:it.story_url)
        }

        webview.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                if(webViewSuccess){
                    progress_bar.visibility = View.GONE
                    webview.visibility = View.VISIBLE
                }
            }

            override fun onReceivedError(
                view: WebView?,
                request: WebResourceRequest?,
                error: WebResourceError?
            ) {
                super.onReceivedError(view, request, error)
                webViewSuccess = false

                progress_bar.visibility = View.GONE
                webview.visibility = View.GONE
                no_internet_message.visibility = View.VISIBLE
                no_internet_message.publication_title.text = publicationsViewModel.mSelectedPublication!!.title?:publicationsViewModel.mSelectedPublication!!.story_title
                no_internet_message.publication_info.text = publicationsViewModel.mSelectedPublication!!.author
            }
        }
    }
}