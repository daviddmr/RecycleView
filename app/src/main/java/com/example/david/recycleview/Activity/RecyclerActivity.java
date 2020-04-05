package com.example.david.recycleview.Activity;

import android.os.Bundle;

import com.example.david.recycleview.Adapter.MyAdapter;
import com.example.david.recycleview.R;
import com.example.david.recycleview.viewModels.RecyclerViewModel;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        RecyclerViewModel viewModel = new ViewModelProvider(this).get(RecyclerViewModel.class);

        //Basic setup of the recycler view
        RecyclerView mRecyclerView = findViewById(R.id.rv_main_list);
        mRecyclerView.setHasFixedSize(true);

        //Setting scroll listener (this is a plus)
        mRecyclerView.addOnScrollListener(viewModel.onScrollListener());
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this);
        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        List<String> mList = viewModel.getRandomList(10);

        MyAdapter mAdapter = new MyAdapter(this, mList);
        mRecyclerView.setAdapter(mAdapter);
    }
}
