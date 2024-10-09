package com.rawaha.foodering.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel
import com.rawaha.foodering.R
import com.rawaha.foodering.adapter.PopularFoodAdapter
import com.rawaha.foodering.data.PopularFood
import com.rawaha.foodering.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel(R.drawable.benner1, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner2, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner3, ScaleTypes.FIT))


        val imageSlider = binding.imageSliderHome
        imageSlider.setImageList(imageList)
        imageSlider.setImageList(imageList, ScaleTypes.FIT)
        imageSlider.setItemClickListener(object : ItemClickListener{
            override fun doubleClick(position: Int) {
            }

            override fun onItemSelected(position: Int) {
                val imagePosition = imageList[position]
                val imageMessage = "Image selected $position"
                Toast.makeText(requireContext(), imageMessage, Toast.LENGTH_SHORT).show()
            }

        })

        val foodList = listOf(
            PopularFood(name = "Bacon and Cheese Heaven", image = R.drawable.menu1, price = 7.0),
            PopularFood(name = "Chicago Style Hot Dog", image = R.drawable.menu2, price = 8.0),
            PopularFood(name = "Classic Beef Burger", image = R.drawable.menu3, price = 6.0),
            PopularFood(name = "Chili Cheese Dog", image = R.drawable.menu4, price = 7.0),
            PopularFood(name = "Hawaiian BBQ Dog", image = R.drawable.menu5, price = 8.0),
            PopularFood(name = "Hawaiian Paradise", image = R.drawable.menu6, price = 9.0)
        )

        val adapter = PopularFoodAdapter(foodList)

        binding.recyclerViewHome.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewHome.adapter = adapter

    }

    companion object {

    }
}