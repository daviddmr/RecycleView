package com.example.david.recycleview.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.david.recycleview.Adapter.MyAdapter;
import com.example.david.recycleview.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    List<String> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        //Basic setup of the recycler view
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_main_list);
        mRecyclerView.setHasFixedSize(true);
        //Setting scrolllistener (this is a plus)
        mRecyclerView.setOnScrollListener(onScrollListener());
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this);
        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        mList = getRandomList(10);

        MyAdapter mAdapter = new MyAdapter(this, mList);
        mRecyclerView.setAdapter(mAdapter);

    }

    //Get a random list with "size" elements
    private List<String> getRandomList(int size) {
        List<String> mList = new ArrayList<>();

        for(int i = 0; i < size; i++){
          mList.add("Elemento " + i);
        }

        return mList;
    }

    private RecyclerView.OnScrollListener onScrollListener() {
        return new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                LinearLayoutManager mLinearLayoutManager = (LinearLayoutManager) mRecyclerView.getLayoutManager();
                MyAdapter myAdapter = (MyAdapter) mRecyclerView.getAdapter();

                //When the last element is showed
                if(mList.size() == mLinearLayoutManager.findLastCompletelyVisibleItemPosition() + 1) {
                    //Load 10 more, for example
                    List<String> listAux = getRandomList(10);
                    for(String str : listAux) {
                        myAdapter.addItem(str, mList.size());
                    }
                }
            }
        };
    }
}
