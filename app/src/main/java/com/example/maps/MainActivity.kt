package com.example.maps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.maps.databinding.ActivityMainBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MainActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var binding: ActivityMainBinding

    private var lokasi: MutableList<Lokasi> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.google_map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        lokasi.add(Lokasi("Kantor Polisi", -6.914744, 107.609810))
        lokasi.add(Lokasi("Kantor Polisi", -6.915744, 107.609810))
        lokasi.add(Lokasi("Kantor Polisi", -6.916744, 107.609810))
        lokasi.add(Lokasi("Kantor Polisi", -6.917744, 107.609810))
    }

    override fun onMapReady(googleMap: GoogleMap) {
        googleMap.uiSettings.isZoomControlsEnabled = true
        googleMap.uiSettings.isZoomGesturesEnabled = true
        googleMap.uiSettings.isScrollGesturesEnabled = true

        for (i in lokasi.indices) {
            val latLng = LatLng(lokasi[i].lat, lokasi[i].lng)
            googleMap.addMarker(MarkerOptions().position(latLng).title(lokasi[i].nama))
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng))
            googleMap.animateCamera(CameraUpdateFactory.zoomTo(15f))
        }
    }
}