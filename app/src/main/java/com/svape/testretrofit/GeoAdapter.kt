package com.svape.testretrofit

import android.app.AlertDialog
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import java.text.DecimalFormat

class GeoAdapter(private val listG: List<Features>) : RecyclerView.Adapter<GeoAdapter.viewHolder>() {

    private val displayFormat = DecimalFormat("#.####")

    private val fullFormat = DecimalFormat("#.##########")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return viewHolder(view)
    }

    override fun getItemCount(): Int = listG.size

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val geoJson = listG[position]

        val name = geoJson.properties?.name ?: "Sin nombre"
        val country = geoJson.properties?.adm0name ?: "País desconocido"
        val latitude = geoJson.properties?.latitude
        val longitude = geoJson.properties?.longitude

        holder.textViewName.text = name
        holder.textViewCountry.text = country
        holder.textViewLat.text = if (latitude != null) displayFormat.format(latitude) else "N/A"
        holder.textViewLong.text = if (longitude != null) displayFormat.format(longitude) else "N/A"

        holder.buttonLocation.setOnClickListener {
            // Preparar información completa con todos los decimales
            val latFull = if (latitude != null) fullFormat.format(latitude) else "N/A"
            val longFull = if (longitude != null) fullFormat.format(longitude) else "N/A"

            val builder = AlertDialog.Builder(holder.itemView.context)
            val dialog = builder
                .setTitle("Detalles de Ubicación")
                .setMessage(
                    """
                    Ubicación: $name
                    País: $country
                    Latitud: $latFull
                    Longitud: $longFull
                    
                    Otros datos:
                    Capital: ${if (geoJson.properties?.adm0cap == 1) "Sí" else "No"}
                    Población: ${geoJson.properties?.popMax ?: "Desconocida"}
                    """.trimIndent()
                )
                .setPositiveButton("Cerrar") { dialog, _ -> dialog.dismiss() }
                .create()
            dialog.show()
            dialog.getButton(AlertDialog.BUTTON_POSITIVE)?.setTextColor(
                ContextCompat.getColor(holder.itemView.context, R.color.alertButton)
            )
            try {
                val titleView = dialog.findViewById<TextView>(androidx.appcompat.R.id.alertTitle)
                titleView?.setTextColor(ContextCompat.getColor(holder.itemView.context, R.color.alertTitle))
            } catch (e: Exception) {
                // Si falla, simplemente continuamos sin cambiar el color del título
            }
            dialog.window?.setBackgroundDrawable(
                ColorDrawable(ContextCompat.getColor(holder.itemView.context, R.color.alertBackground))
            )
        }
    }

    class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewName = itemView.findViewById<TextView>(R.id.nameLocation)
        val textViewCountry = itemView.findViewById<TextView>(R.id.countryLocation)
        val textViewLat = itemView.findViewById<TextView>(R.id.latLocation)
        val textViewLong = itemView.findViewById<TextView>(R.id.longLocation)
        val buttonLocation = itemView.findViewById<Button>(R.id.locationP)
    }
}