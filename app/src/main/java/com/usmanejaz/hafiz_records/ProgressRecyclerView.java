package com.usmanejaz.hafiz_records;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class myRecyclerViewAdapter extends RecyclerView.Adapter<myRecyclerViewAdapter.MyVH> {

    List<Profile> friendsList;
    DBHelper db;
    public myRecyclerViewAdapter(List<Profile> friendsList) {
        this.friendsList = friendsList;
    }

    @NonNull
    @Override
    public myRecyclerViewAdapter.MyVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.progress_recyclerview, parent, false);
        return new MyVH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull myRecyclerViewAdapter.MyVH holder, int position) {
        holder.data=friendsList.get(position);
        holder.textViewFriendName.setText(holder.data.name);
        holder.textViewdateFriend.setText(String.valueOf(holder.data.id));
        holder.textViewCity.setText(holder.data.section);

        holder.delete.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               db = new DBHelper(v.getContext().getApplicationContext());
               db.deleteStudent(String.valueOf(holder.data.id));
               Intent intent = new Intent(v.getContext(), MainActivity.class);
               v.getContext().startActivity(intent);
               ((Activity)v.getContext()).finish();
           }
        });
    }

    @Override
    public int getItemCount() {
        return friendsList.size();
    }


    public class MyVH extends RecyclerView.ViewHolder {
        TextView textViewFriendName;
        TextView textViewdateFriend;
        TextView textViewCity;
        AppCompatButton delete;
        Profile data;
        public MyVH(@NonNull View itemView) {
            super(itemView);
            textViewFriendName = itemView.findViewById(R.id.textViewFriendName);
            textViewdateFriend = itemView.findViewById(R.id.textViewDate);
            textViewCity = itemView.findViewById(R.id.textViewCity);
            delete = itemView.findViewById(R.id.delProfile);
        }
    }
}