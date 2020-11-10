package com.example.madlevel3task2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_portal.view.*

class PortalAdapter (var context: Context, var arrayList: ArrayList<Portal>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun databind(portal: Portal) {
            itemView.portalVak.text = portal.portalText
            itemView.portalUrl.text = portal.portalUrl

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val ViewHolder = LayoutInflater.from(parent.context).inflate(R.layout.item_portal, parent, false)
        return ViewHolder(ViewHolder)

    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.databind(portal[position])
    }


}