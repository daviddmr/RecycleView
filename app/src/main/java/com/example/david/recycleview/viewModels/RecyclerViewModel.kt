package com.example.david.recycleview.viewModels

import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.david.recycleview.adapters.MyAdapter

class RecyclerViewModel : ViewModel() {

    fun getRandomList(numberOfItems: Int): List<String> {
        val mList = mutableListOf<String>()

        for (i in 0..numberOfItems) {
            mList.add("Element: $i")
        }

        return mList
    }

    fun onScrollListener(): RecyclerView.OnScrollListener {
        return object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val mLinearLayoutManager: LinearLayoutManager = recyclerView.layoutManager as LinearLayoutManager
                val myAdapter: MyAdapter = recyclerView.adapter as MyAdapter
                val mList = myAdapter.itemList

                if (mList.size == mLinearLayoutManager.findLastCompletelyVisibleItemPosition() + 1) {
                    val mListAux = getRandomList(10)
                    mListAux.forEach {
                        myAdapter.addItem(it, mList.size)
                    }
                }
            }
        }
    }
}