package com.example.listview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class PresidentListAdapter(context: Context, val presidents : MutableList<President>): BaseAdapter() {

    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    //1
    override fun getCount(): Int {
        return presidents.size
    }

    //2
    override fun getItem(position: Int): Any {
        return presidents[position]
    }

    //3
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView = inflater.inflate(R.layout.item_president, parent, false)

        val thisPresident = presidents[position]

        var tv = rowView.findViewById(R.id.tvName) as TextView
        tv.text = thisPresident.name

        tv = rowView.findViewById(R.id.tvStartDuty) as TextView
        tv.text = Integer.toString(thisPresident.startDuty)

        tv = rowView.findViewById(R.id.tvEndDuty) as TextView
        tv.text = Integer.toString(thisPresident.endDuty)

        return rowView
    }
}