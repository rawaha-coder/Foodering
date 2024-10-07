package com.rawaha.foodering

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.rawaha.foodering.databinding.ActivityChooseLocationBinding

class ChooseLocationActivity : AppCompatActivity() {
    private val binding: ActivityChooseLocationBinding by lazy {
        ActivityChooseLocationBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        val listLocation = arrayOf(
            "Île-de-France",
            "Val-de-Marne",
            "Hauts-de-Seine",
            "Seine-Saint-Denis",
            "Yvelines",
            "Essonne",
            "Seine-et-Marne"
        )
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listLocation)
        val autoCompleteTextView: AutoCompleteTextView = binding.listOfLocation
        autoCompleteTextView.setAdapter(adapter)

    }
}