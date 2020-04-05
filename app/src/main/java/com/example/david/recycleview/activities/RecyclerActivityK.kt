package com.example.david.recycleview.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.david.recycleview.R
import com.example.david.recycleview.viewModels.RecyclerViewModel
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerActivityK : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        setupViewComponents()
    }

    private fun setupViewComponents() {
        rv_main_list.setHasFixedSize(true)
        val mLinearLayoutManager = LinearLayoutManager(this)
        mLinearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        rv_main_list.layoutManager = mLinearLayoutManager
    }
}