package com.example.david.recycleview.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.david.recycleview.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<String> mList;
    private LayoutInflater mLayoutInflater;

    //Basic Constructor
    public MyAdapter(Context ctx, List<String> mList) {
        this.mList = mList;
        mLayoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    //Called always that is needful create a new view
    @Override
    public MyViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        //Showing the item layout
        View view = mLayoutInflater.inflate(R.layout.item_list, parent, false);

        return new MyViewHolder(view);
    }

    //Called all the time
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        //Setting the value of the elements on "item" layout
        holder.tvText.setText(mList.get(position));
    }

    //Return the size of the list of the components into the list
    @Override
    public int getItemCount() {
        return mList.size();
    }

    //Customized method to add a new item into the list
    public void addItem(String str, int position) {
        mList.add(str);
        notifyItemInserted(position);
    }

    public List<String> getItemList() {
        return mList;
    }

    //My customize view holder
    //Instantiating elements value from item layout
    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvText;

        MyViewHolder(View itemView) {
            super(itemView);

            tvText = itemView.findViewById(R.id.tv_text);
        }
    }
}
