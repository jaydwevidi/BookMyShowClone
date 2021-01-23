package com.example.bookmyshowclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        setupRecyclerView()
    }

    fun setupRecyclerView(){
        var packList = mutableListOf<CityPack>()
        addItemsToList(packList)

        var myAdapter = MyRecyclerAdapter(packList , applicationContext)
        myRecyclerView.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = myAdapter
        }

    }

    fun addItemsToList(list : MutableList<CityPack>){

        val x1 = MyCityObject(23,"Delhi","das")
        var x2 = MyCityObject(23,"Mumbai","das")
        var x3 = MyCityObject(23,"Ahemdabad","das")
        var x4 = MyCityObject(23,"Pune","das")
        var x5 = MyCityObject(23,"Calicut","das")
        var x6 = MyCityObject(23,"new York","das")
        var x7 = MyCityObject(23,"LA","das")
        var x8 = MyCityObject(23,"London","das")
        var x9 = MyCityObject(23,"Lucknow","das")

        list.add(CityPack(x1,x2,x3))
        list.add(CityPack(x4,x5,x6))
        list.add(CityPack(x7,x8,x9))
    }
}