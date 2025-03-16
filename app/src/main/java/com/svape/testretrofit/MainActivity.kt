package com.svape.testretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.svape.testretrofit.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var data = ArrayList<Features>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configurar RecyclerView - no es necesario si ya está configurado en XML
        // binding.rvGeo.layoutManager = LinearLayoutManager(this@MainActivity)

        // Obtener datos de la API
        getGeoLocation()
    }

    private fun getGeoLocation() {
        val retrofit = ServiceBuilder.buildService(ServiceInterface::class.java)

        retrofit.getGeoJson().enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                try {
                    val responseBody = response.body()!!
                    data = responseBody.features

                    // Configurar adaptador con los datos
                    val adapter = GeoAdapter(data)
                    binding.rvGeo.adapter = adapter

                } catch (ex: Exception) {
                    ex.printStackTrace()
                    Log.e("MainActivity", "Error al procesar la respuesta: ${ex.message}")
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                Log.e("MainActivity", "Error en la llamada a la API: ${t.message}")
            }
        })
    }
}