package com.usmanejaz.hafiz_records;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class myProgressViewAdapter extends RecyclerView.Adapter<myProgressViewAdapter.VH> {

    List<Progress> friendsList;
    public myProgressViewAdapter(List<Progress> friendsList) {
        this.friendsList = friendsList;
    }

    @NonNull
    @Override
    public myProgressViewAdapter.VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.progress, parent, false);
        return new VH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull myProgressViewAdapter.VH holder, int position) {
        holder.data=friendsList.get(position);
        holder.Name.setText("Student Id: " + holder.data.id);
        holder.sabaq_para.setText("Para: " + String.valueOf(holder.data.para_sabaq));
        holder.startverse.setText("Page(" + holder.data.starting_sabaq + "  -");
        holder.endverse.setText(String.valueOf(holder.data.ending_sabaq) + ")");
        holder.sabqi_para.setText(String.valueOf(holder.data.sabqi));
        holder.manzil_para.setText(String.valueOf(holder.data.manzil));

        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, EditActivity.class);
                intent.putExtra("id", String.valueOf(holder.data.id) );
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return friendsList.size();
    }


    public class VH extends RecyclerView.ViewHolder {
        AppCompatButton Name;
        AppCompatButton sabaq_para;
        TextView startverse;
        TextView endverse;
        TextView sabqi_para;
        TextView manzil_para;
        AppCompatButton edit;
        Progress data;
        public VH(@NonNull View itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.Name);
            sabaq_para = itemView.findViewById(R.id.sabaq_para);
            startverse = itemView.findViewById(R.id.startverse);
            endverse = itemView.findViewById(R.id.endverse);
            sabqi_para = itemView.findViewById(R.id.sabqi_para);
            manzil_para = itemView.findViewById(R.id.manzil_para);
            edit = itemView.findViewById(R.id.edit);


        }
    }
}