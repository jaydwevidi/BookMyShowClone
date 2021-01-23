package com.example.bookmyshowclone


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.custom_item_for_recyclerview.view.*

class MyRecyclerAdapter(var dataList: MutableList<CityPack> , var context:Context)
    : RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var t1 = itemView.t1
        var t2 = itemView.t2
        var t3 = itemView.t3
        var i1 = itemView.i1
        var i2 = itemView.i2
        var i3 = itemView.i3

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.custom_item_for_recyclerview ,parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.t1.text =  dataList[position].c1.name
        holder.t2.text =  dataList[position].c2.name
        holder.t3.text =  dataList[position].c3.name

        holder.i1.setImageResource(getResourceID(dataList[position].c1.name))
        holder.i2.setImageResource(getResourceID(dataList[position].c2.name))
        holder.i3.setImageResource(getResourceID(dataList[position].c3.name))

        holder.i1.setOnClickListener {
            //Toast.makeText(context, dataList[position].c1.name, Toast.LENGTH_SHORT).show()

            var myIntent = Intent(context , page::class.java)
            myIntent.putExtra("cityName",dataList[position].c1.name,)
            myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(myIntent)
        }

        holder.i2.setOnClickListener {
            //Toast.makeText(context, dataList[position].c2.name, Toast.LENGTH_SHORT).show()

            var myIntent = Intent(context , page::class.java)
            myIntent.putExtra("cityName",dataList[position].c2.name,)
            myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(myIntent)

        }

        holder.i3.setOnClickListener {
           // Toast.makeText(context, dataList[position].c3.name, Toast.LENGTH_SHORT).show()

            var myIntent = Intent(context , page::class.java)
            myIntent.putExtra("cityName",dataList[position].c3.name,)
            myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(myIntent)
        }
    }

    fun getResourceID(name: String):Int{
        return when(name){
                "Delhi"     ->  R.drawable.ncr
                "Mumbai"    ->  R.drawable.mumbai
                "Ahemdabad" ->  R.drawable.ahd
                "Pune"      ->  R.drawable.pune
                "Calicut"   ->  R.drawable.bang
                "new York"  ->  R.drawable.chen
                "LA"        ->  R.drawable.hyd
                "London"    ->  R.drawable.ncr
                "Lucknow"   ->  R.drawable.bang
            else -> R.drawable.chen
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}