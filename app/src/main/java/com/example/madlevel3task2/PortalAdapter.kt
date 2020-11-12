package com.example.madlevel3task2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_portal.view.*

class PortalAdapter(private val arrayList: List<Portal>, val clickListener: (Portal) -> Unit ) : RecyclerView.Adapter<PortalAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun databind(
            portal: Portal,
            clickListener: (Portal) -> Unit
        ) {
            itemView.portalVak.text = portal.portalText
            itemView.portalUrl.text = portal.portalUrl
            // whenever the View item is clicked, Android calls the click listener.
            itemView.setOnClickListener{clickListener(portal)}

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_portal, parent, false)
        )

    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // the clickListener parameter has been added so that the viewholder will bind with the onBindViewHolder
        holder.databind(arrayList[position], clickListener)

    }

}