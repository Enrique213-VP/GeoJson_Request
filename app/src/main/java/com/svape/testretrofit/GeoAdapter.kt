package com.svape.testretrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GeoAdapter(private val listG: List<Features>) : RecyclerView.Adapter<GeoAdapter.viewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return viewHolder(view)
    }

    override fun getItemCount(): Int = listG.size

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val GeoJson = listG[position]

        holder.textViewName.setText(GeoJson.properties?.name)
        holder.textViewlat.setText(GeoJson.properties?.latitude.toString())
        holder.textViewlong.setText(GeoJson.properties?.longitude.toString())
    }


    class viewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {

        val textViewName = ItemView.findViewById<TextView>(R.id.nameLocation)
        val textViewlat = ItemView.findViewById<TextView>(R.id.latLocation)
        val textViewlong = ItemView.findViewById<TextView>(R.id.longLocation)

    }


}