package com.venkat.weatherapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.venkat.weatherapp.view.ResultsActivity
import com.venkat.weatherapp.model.Location
import com.venkat.weatherapp.R
import kotlinx.android.synthetic.main.rv_location_child.view.*

class LocationAdapter( private val context: Context) :
    RecyclerView.Adapter<LocationAdapter.ViewHolder>() {
    private var list: List<Location> = ArrayList()

    fun setLocationList(list: List<Location>){
        this.list = list
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = list[position].title
        holder.rootView.setOnClickListener {
            val intent = Intent(context, ResultsActivity::class.java)
            intent.putExtra("Location", list[position].woeid)
            intent.putExtra("name", list[position].title)
            context.startActivity(intent)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.rv_location_child,
                parent,
                false
            )
        )
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val name = v.tv_location_name!!
        val rootView = v.child_root!!
    }

}