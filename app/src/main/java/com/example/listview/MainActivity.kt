package com.example.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.listview.GlobalModel.presidents
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       list_view.adapter = PresidentListAdapter(this, GlobalModel.presidents)


        list_view.setOnItemClickListener { _, _, position, _ ->
            Log.d("USR","Selected $position")
            val preziName = GlobalModel.presidents[position].name
            viewModel = ViewModelProvider( this).get(MainViewModel:: class.java)
            viewModel.hits(preziName).observe( this, Observer {
                Log.d( "FYI", "${it.query.searchinfo.totalhits}")
                hit_view.text = "Total Hits: ${it.query.searchinfo.totalhits}"
            })

            detailView.text = GlobalModel.presidents[position].toString()

        }


}

}