package com.example.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import com.example.listview.GlobalModel.presidents
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       list_view.adapter = PresidentListAdapter(this, GlobalModel.presidents)


        list_view.setOnItemClickListener { _, _, position, _ ->
            Log.d("USR","Selected $position")
            detailView.text = GlobalModel.presidents[position].toString()
        }
    }
}