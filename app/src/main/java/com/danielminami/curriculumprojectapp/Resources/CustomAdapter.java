package com.danielminami.curriculumprojectapp.Resources;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.danielminami.curriculumprojectapp.Model.Model_Language;
import com.danielminami.curriculumprojectapp.R;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private ArrayList<Model_Language> dataList;
    private Context context;

    public void setList(ArrayList<Model_Language> list) {
        dataList = list;
    }

    public CustomAdapter(Context context,ArrayList<Model_Language> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        public final View myView;

        TextView txtName;
        TextView txtLevel;

        CustomViewHolder(View itemView) {
            super(itemView);
            myView = itemView;

            txtName = myView.findViewById(R.id.txt_name);
            txtLevel = myView.findViewById(R.id.txt_level);
        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.view_holder_language, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.txtName.setText(dataList.get(position).getName());
        holder.txtLevel.setText(dataList.get(position).getCefr());


    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}