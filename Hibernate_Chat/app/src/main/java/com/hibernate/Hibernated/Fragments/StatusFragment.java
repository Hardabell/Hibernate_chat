package com.hibernate.Hibernated.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.hibernate.Hibernated.Adapter.StatusAdapter;
import com.hibernate.Hibernated.Adapter.UserAdapter;
import com.hibernate.Hibernated.CameraActivity;
import com.hibernate.Hibernated.Model.Statuslist;
import com.hibernate.Hibernated.Model.User;
import com.hibernate.Hibernated.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class StatusFragment extends Fragment {
    CircleImageView image_profile;
    TextView username, timeStatus;
    DatabaseReference reference;
    FirebaseUser fuser;

    private RecyclerView recyclerView;
    private RelativeLayout myStatus;
    private StatusAdapter statusAdapter;
    private List<User> mUsers;

    StorageReference storageReference;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_status, container, false);

        image_profile = view.findViewById(R.id.profile_image);
        username = view.findViewById(R.id.username);
        timeStatus = view.findViewById(R.id.timeStatus);

        storageReference = FirebaseStorage.getInstance().getReference("imgStatus");

        fuser = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users").child(fuser.getUid());

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (getContext() == null){
                    return;
                }
                User user = dataSnapshot.getValue(User.class);
                Glide.with(getContext()).load(user.getImageURL()).into(image_profile);
                if(user.getTimeStatus() !=null && !user.getTimeStatus().isEmpty()){
                    timeStatus.setText(user.getTimeStatus());
                }else{
                    timeStatus.setText("Tap to add new status");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        myStatus = view.findViewById(R.id.mystatus);
        myStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fuser = FirebaseAuth.getInstance().getCurrentUser();
                reference = FirebaseDatabase.getInstance().getReference("Users").child(fuser.getUid());

                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        User user = dataSnapshot.getValue(User.class);
                        Calendar c = Calendar.getInstance();
                        int mHour1 = c.get(Calendar.HOUR_OF_DAY);
                        String cTime = Integer.toString(mHour1);
                        //ambil jam awal data tStatus
                        if(user.getTimeStatus() != null && !user.getTimeStatus().isEmpty()){
                            String sTime = user.getTimeStatus();
                            String arr[] = sTime.split(":",2);
                            String stime = arr[0];
                            int stime1 = Integer.valueOf(stime);
                            int result = stime1-1;
                            String result1 = Integer.toString(result);
                            if(cTime.equals(result1)){
                                HashMap<String, Object> map = new HashMap<>();
                                map.put("imgStatus", "");
                                map.put("txtStatus", "");
                                map.put("timeStatus", "");
                                reference.updateChildren(map);
                                Intent intent = new Intent(getActivity(), CameraActivity.class);
                                startActivity(intent);
                            }
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                    }
                });
                Intent intent = new Intent(getActivity(), CameraActivity.class);
                startActivity(intent);
            }
        });

        recyclerView = view.findViewById(R.id.statuslain);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mUsers = new ArrayList<>();

        readStatus();
        return view;
    }

    private void readStatus() {
        final FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    mUsers.clear();
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        User user = snapshot.getValue(User.class);
                        if (user.getId() != null && !user.getId().equals(firebaseUser.getUid())) {
                            if(user.getImgStatus() != null && user.getTxtStatus() != null && !user.getImgStatus().equals("default") && !user.getTxtStatus().equals("default")){
                                mUsers.add(user);
                            }
                        }
                    }
                    statusAdapter = new StatusAdapter(getContext(), mUsers);
                    recyclerView.setAdapter(statusAdapter);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}