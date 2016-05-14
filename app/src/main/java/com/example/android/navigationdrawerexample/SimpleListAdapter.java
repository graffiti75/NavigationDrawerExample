package com.example.android.navigationdrawerexample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class SimpleListAdapter extends RecyclerView.Adapter<SimpleListAdapter.ViewHolder> {

    //--------------------------------------------------
    // Attributes
    //--------------------------------------------------

    private List<String> mValues;

    //--------------------------------------------------
    // Constructor
    //--------------------------------------------------

    public SimpleListAdapter(List<String> items) {
        mValues = items;
    }

    //--------------------------------------------------
    // Adapter Methods
    //--------------------------------------------------

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_simple_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String text = mValues.get(position);
        holder.mTextView.setText(text);
        Glide.with(holder.mImageView.getContext()).load("http://goo.gl/vm0Tht")
            .fitCenter().into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    //--------------------------------------------------
    // View Holder
    //--------------------------------------------------

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTextView;

        public ViewHolder(View view) {
            super(view);
            mImageView = (ImageView) view.findViewById(R.id.id_adapter_simple_list__image_view);
            mTextView = (TextView) view.findViewById(R.id.id_adapter_simple_list__text_view);
        }
    }
}
