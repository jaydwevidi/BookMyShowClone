package com.example.bookmyshowclone


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.custom_item_for_recyclerview.view.*

class MyRecyclerAdapter(var dataList: MutableList<MyCityObject>, var context: Context) :
    RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder>() {

    private val completeList: List<MyCityObject> = dataList

    fun filter(filterString: String) {
        dataList = completeList.toMutableList()
        dataList.clear()
        for (i in completeList) {
            if (i.name.contains(filterString, true))
                dataList.add(i)
        }
        notifyDataSetChanged()
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var t1: TextView = itemView.t1
        var i1: ImageView = itemView.i1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.custom_item_for_recyclerview,
            parent,
            false
        )
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.t1.text = dataList[position].name

        /*holder.i1.setImageResource(getResourceID(dataList[position].c1.name))
        holder.i2.setImageResource(getResourceID(dataList[position].c2.name))
        holder.i3.setImageResource(getResourceID(dataList[position].c3.name))*/

        Glide.with(holder.itemView)
            .load(getImageURL(dataList[position].name))
            .fitCenter()
            .into(holder.i1)



        holder.i1.setOnClickListener {

            var myIntent = Intent(context, page::class.java)
            myIntent.putExtra("cityName", dataList[position].name)
            myIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(myIntent)
        }

    }

    fun getImageURL(name: String): String {
        return when (name) {
            "Delhi" -> "https://in.bmscdn.com/m6/images/common-modules/regions/ncr.png"
            "Mumbai" -> "https://in.bmscdn.com/m6/images/common-modules/regions/mumbai.png"
            "Banglore" -> "https://in.bmscdn.com/m6/images/common-modules/regions/bang.png"
            "Hyderabad" -> "https://in.bmscdn.com/m6/images/common-modules/regions/hyd.png"
            "Ahmedabad" -> "https://in.bmscdn.com/m6/images/common-modules/regions/ahd.png"
            "Kolkatta" -> "https://in.bmscdn.com/m6/images/common-modules/regions/kolk.png"
            else -> "https://in.bmscdn.com/m6/images/common-modules/regions/koch.png"
        }
    }

    fun getResourceID(name: String): Int {
        return when (name) {
            "Delhi" -> R.drawable.ncr
            "Mumbai" -> R.drawable.mumbai
            "Ahemdabad" -> R.drawable.ahd
            "Pune" -> R.drawable.pune
            "Calicut" -> R.drawable.bang
            "new York" -> R.drawable.chen
            "LA" -> R.drawable.hyd
            "London" -> R.drawable.ncr
            "Lucknow" -> R.drawable.bang
            else -> R.drawable.chen
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}