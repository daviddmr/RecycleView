package com.example.david.recycleview.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.david.recycleview.R
import com.example.david.recycleview.adapters.MyAdapterK
import com.example.david.recycleview.viewModels.RecyclerViewModel
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerActivityK : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        val viewModel = ViewModelProvider(this).get(RecyclerViewModel::class.java)

        rv_main_list.setHasFixedSize(true)
        rv_main_list.addOnScrollListener(viewModel.onScrollListener())
        val mLinearLayoutManager = LinearLayoutManager(this)
        mLinearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        rv_main_list.layoutManager = mLinearLayoutManager

        val mList = viewModel.getRandomList(10)

        val myAdapter = MyAdapterK(this, mList.toMutableList())
        rv_main_list.adapter = myAdapter
    }
}