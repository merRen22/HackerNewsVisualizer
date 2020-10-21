package com.hacker.hackernewsvisualizer.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.hacker.hackernewsvisualizer.R
import com.hacker.hackernewsvisualizer.data.model.Publication
import com.hacker.hackernewsvisualizer.viewmodel.PublicationsViewModel
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.collections.ArrayList

class PublicationsAdapter(
    val publicationsViewModel: PublicationsViewModel,
    val controller: NavController) : RecyclerView.Adapter<PublicationsAdapter.ViewHolder>() {

    var listPublications = ArrayList<Publication>()
    var simpleDateFormat: SimpleDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")

    var currentDate: Date?= null

    init {
        val currentTime: String = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
            .withZone(ZoneOffset.UTC)
            .format(Instant.now())

        currentDate = simpleDateFormat.parse(currentTime)!!
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_publication, parent, false)
    )

    override fun getItemCount() = listPublications.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val publication = listPublications[position] as Publication

        holder.title.text = publication.story_title?:publication.title

        holder.authorInfo.text = "${publication.author} - ${dateTimeDifference(publication.created_at)}"

        holder.itemView.setOnClickListener {
            publicationsViewModel.mSelectedPublication = publication
            controller.navigate(R.id.action_publicationsFragment_to_publicationDetail)
        }
    }

    fun updateData(data: List<Publication>) {
        listPublications.clear()
        listPublications.addAll(data)
        notifyDataSetChanged()
    }

    fun removeItem(position: Int) {
        listPublications.removeAt(position)
        notifyDataSetChanged()
    }

    fun restoreItem(item: Publication, position: Int) {
        listPublications.add(position, item)
        notifyItemInserted(position)
    }

    private fun dateTimeDifference(creationTime: String?): String{
        if(creationTime.isNullOrEmpty()){
            return "No time set"
        }

        val startDate: Date = simpleDateFormat.parse(creationTime)!!

        var different: Long = currentDate!!.time - startDate.time

        val secondsInMilli: Long = 1000
        val minutesInMilli = secondsInMilli * 60
        val hoursInMilli = minutesInMilli * 60
        val daysInMilli = hoursInMilli * 24

        val elapsedDays: Long = different / daysInMilli

        if(elapsedDays > 1) return "$elapsedDays d"
        if(elapsedDays == 1L) return "yesterday"

        val elapsedHours = different / hoursInMilli
        if(elapsedHours >= 1) return "$elapsedHours h"

        val elapsedMinutes = different / minutesInMilli
        if(elapsedMinutes >= 1) return "$elapsedMinutes m"

        val elapsedSeconds = different / secondsInMilli
        return "$elapsedSeconds s"
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.publication_title)
        val authorInfo: TextView = itemView.findViewById(R.id.publication_info)
    }
}