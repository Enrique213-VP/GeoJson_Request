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


        //binding.rvGeo.layoutManager = LinearLayoutManager(this@MainActivity)

        getGeoLocation()
    }

    private fun getGeoLocation() {
        val retrofit = ServiceBuilder.buildService(ServiceInterface::class.java)

        retrofit.getGeoJson().enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                try {
                    val responseBody = response.body()!!
                    data = responseBody.features

                    var adapter = GeoAdapter(data)
                    binding.rvGeo.adapter = adapter

                } catch (ex: java.lang.Exception) {
                    ex.printStackTrace()
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                Log.d("Failed", "API Failed" + t.message)
            }

        })
    }
}