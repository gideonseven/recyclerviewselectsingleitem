package com.don.recyclerviewselectsingleitem

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    lateinit var adapter: MyAdapter
    var myList: MutableList<MyMdl> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addItems()

        val linearLayoutManager = LinearLayoutManager(this)
        my_rv.layoutManager = linearLayoutManager
        my_rv.setHasFixedSize(true)
        my_rv.isNestedScrollingEnabled = false
        adapter = MyAdapter(this, myList)
        my_rv.adapter = adapter
    }


    private fun addItems() {
        myList.add(MyMdl("VANYA", "Ini data pertama", false))
        myList.add(MyMdl("Diah", "Ini data kedua", false))
        myList.add(MyMdl("Sekar", "Ini data ketiga", false))
    }

}
