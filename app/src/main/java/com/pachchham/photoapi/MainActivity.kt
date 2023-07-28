package com.pachchham.photoapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.pachchham.photoapi.Adapter.WallpaperAdapter
import com.pachchham.photoapi.Model.PhotoModel
import com.pachchham.photoapi.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    var auth = "YKRwNZEdFIQAI598LYkoohDgcvCi1oM6deNueyL0ttXOuWSsIppUg57y"
    lateinit var adapter: WallpaperAdapter
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        adapter = WallpaperAdapter()

        binding.btnChangeImage.setOnClickListener {
            callApi()
        }
    }

    private fun callApi() {
        var txt = binding.edtHint.text.toString()

        var api: ApiInterface = ApiClient.getApiClient()!!.create(ApiInterface::class.java)
        api.getPhoto(auth,txt).enqueue(object : Callback<PhotoModel> {
            override fun onResponse(call: Call<PhotoModel>, response: Response<PhotoModel>) {
                if (response.isSuccessful) {
                    var photos = response.body()?.photos
                    adapter.setPhotos(photos)
                    binding.rcvPhotos.layoutManager = GridLayoutManager(this@MainActivity, 2)
                    binding.rcvPhotos.adapter = adapter
                }
            }

            override fun onFailure(call: Call<PhotoModel>, t: Throwable) {

            }

        })
    }
}