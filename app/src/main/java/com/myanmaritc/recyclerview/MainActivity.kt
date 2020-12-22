package com.myanmaritc.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.myanmaritc.recyclerview.databinding.ActivityMainBinding

//, FlowerAdapter.OnItemClickListener
class MainActivity : AppCompatActivity(){

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val flowerList: ArrayList<Flower> = ArrayList()

        flowerList.add(Flower("Sunflower", 2300, R.drawable.ic_launcher_background))

        val flowerAdapter = FlowerAdapter(flowerList) { item ->
            Toast.makeText(this, item.flowerName, Toast.LENGTH_LONG).show()
        }

        //binding.recyclerView.layoutManager = LinearLayoutManager(this)
//        binding.recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerView.layoutManager = GridLayoutManager(this, 3)
        binding.recyclerView.adapter = flowerAdapter

//        flowerAdapter.setOnClickListener(this)
    }

//    override fun onItemClick(flower: Flower) {
//        Toast.makeText(this, flower.flowerName, Toast.LENGTH_LONG).show()
//    }
}