package com.hacker.hackernewsvisualizer.ui

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.hacker.hackernewsvisualizer.databinding.FragmentPublicationsBinding
import com.hacker.hackernewsvisualizer.viewmodel.PublicationsViewModel
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_publications.*
import javax.inject.Inject


class PublicationsFragment: DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val publicationsViewModel: PublicationsViewModel by activityViewModels { viewModelFactory }

    private lateinit var binding: FragmentPublicationsBinding

    private lateinit var publicationsAdapter: PublicationsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPublicationsBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        publicationsViewModel.getPublications()

        publicationsAdapter = PublicationsAdapter(
            publicationsViewModel,
            this.findNavController()
        )

        publications_list.apply {
            layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
            adapter = publicationsAdapter
        }

        publicationsViewModel.publicationsResult.observe(viewLifecycleOwner, Observer {
            it ?: return@Observer

            progress_bar_publications.visibility = View.GONE
            swiperefresh.visibility = View.VISIBLE
            swiperefresh.isRefreshing = false

            it.successPublications?.let {publications ->
                publicationsAdapter.updateData(publications)
            }

            it.errorPublications?.let {
                val snackbar = Snackbar
                    .make(
                        constraint_layout,
                        getString(it),
                        Snackbar.LENGTH_LONG
                    )
                snackbar.setActionTextColor(Color.YELLOW)
                snackbar.show()
            }
        })

        swiperefresh.setOnRefreshListener {
            progress_bar_publications.visibility = View.VISIBLE
            swiperefresh.visibility = View.GONE
            publicationsViewModel.getPublications()
        }

        val swipeToDeleteCallback: SwipeToDeleteCallback = object : SwipeToDeleteCallback(requireContext()) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, i: Int) {
                val position = viewHolder.adapterPosition
                publicationsViewModel.insertBlacklisted(publicationsAdapter.listPublications[position])
                publicationsAdapter.removeItem(position)
                val snackbar = Snackbar
                    .make(
                        constraint_layout,
                        "Item was removed from the list.",
                        Snackbar.LENGTH_LONG
                    )
                snackbar.setActionTextColor(Color.YELLOW)
                snackbar.show()
            }
        }

        val itemTouchhelper = ItemTouchHelper(swipeToDeleteCallback)
        itemTouchhelper.attachToRecyclerView(publications_list)

    }

}