package com.hibernate.Hibernated.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hibernate.Hibernated.MessageActivity;
import com.hibernate.Hibernated.Model.Chat;
import com.hibernate.Hibernated.Model.Status;
import com.hibernate.Hibernated.R;

import java.util.List;

public class StatusAdapter extends RecyclerView.Adapter<StatusAdapter.ViewHolder> {

    private Context mContext;
    private List<Status> mStatus;
    private boolean ischat;

    public StatusAdapter(Context mContext, List<Status> mStatus, boolean ischat){
        this.mStatus = mStatus;
        this.mContext = mContext;
        this.ischat = ischat;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.status_item, parent, false);
        return new StatusAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mStatus.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{

        public TextView username;
        public ImageView profile_image;

        public ViewHolder(View itemView) {
            super(itemView);

            username = itemView.findViewById(R.id.username);
            profile_image = itemView.findViewById(R.id.profile_image);
        }
    }
}