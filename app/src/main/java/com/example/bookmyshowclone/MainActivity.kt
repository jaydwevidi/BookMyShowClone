package com.example.bookmyshowclone

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.apidemo.api.RFBuilder
import com.example.apidemo.model.City
import com.example.apidemo.model.CompleteData
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        getLocalItemsList()
        getApiItemList()
    }

    fun setupRecyclerView(dataList: MutableList<MyCityObject>) {
        val myAdapter = MyRecyclerAdapter(dataList, applicationContext)
        myRecyclerView.apply {
            layoutManager = GridLayoutManager(applicationContext, 3)
            adapter = myAdapter
        }

        searchBarET.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                Log.d(TAG, "afterTextChanged: $s")
                //myAdapter.restoreData()
                myAdapter.filter(s.toString())
            }
        })
    }

    private fun getApiItemList(): MutableList<CityPack> {
        val built = RFBuilder()
        val g: Call<CompleteData> = built.placeHolderAPI.getCityList()
        val cityPackList = mutableListOf<CityPack>()
        val cityObjectList = mutableListOf<MyCityObject>()

        g.enqueue(object : Callback<CompleteData> {
            override fun onResponse(call: Call<CompleteData>, response: Response<CompleteData>) {
                Log.d(TAG, "onResponse: ")
                if (response.isSuccessful) {
                    val body: List<City> = response.body()!!.Citylist
                    val responseText = StringBuilder()
                    for (i in body) {
                        val tempCityObject = MyCityObject(i.Cityid.toInt(), i.CityName, "url")

                        responseText.append("\n$tempCityObject")
                        cityObjectList.add(tempCityObject)
                    }
                    Log.d(TAG, "onResponse: $responseText")
                } else {
                    Log.d(TAG, "onResponse: ${response.code()}  ")
                }
                setupRecyclerView(cityObjectList)
            }

            override fun onFailure(call: Call<CompleteData>, t: Throwable) {
                Toast.makeText(this@MainActivity, "$t", Toast.LENGTH_SHORT).show()
                Toast.makeText(this@MainActivity, "showing static local data", Toast.LENGTH_LONG)
                    .show()

                Log.e(TAG, "onFailure: $t", t)
                getLocalItemsList()
            }

        })
        return cityPackList
    }

    fun getLocalItemsList(): MutableList<MyCityObject> {
        val list = mutableListOf<MyCityObject>()
        val x1 = MyCityObject(23, "Delhi", "das")
        val x2 = MyCityObject(23, "Mumbai", "das")
        val x3 = MyCityObject(23, "Ahemdabad", "das")
        var x4 = MyCityObject(23, "Pune", "das")
        var x5 = MyCityObject(23, "Calicut", "das")
        var x6 = MyCityObject(23, "new York", "das")
        var x7 = MyCityObject(23, "LA", "das")
        var x8 = MyCityObject(23, "London", "das")
        var x9 = MyCityObject(23, "Lucknow", "das")

        list.add(x1)
        list.add(x2)
        list.add(x3)
        list.add(x4)
        list.add(x5)
        list.add(x6)
        list.add(x7)
        list.add(x8)
        list.add(x9)

        setupRecyclerView(list)
        return list
    }
}