package com.hibernate.Hibernated.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.hibernate.Hibernated.Adapter.StatusAdapter;
import com.hibernate.Hibernated.R;

import java.util.ArrayList;
import java.util.List;

public class StatusFragment extends Fragment {

    private RecyclerView recyclerView;
    private RelativeLayout myStatus;
    private StatusAdapter statusAdapter;
    private List<Status> mStatus;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_status, container, false);
        myStatus = view.findViewById(R.id.mystatus);
        recyclerView = view.findViewById(R.id.statuslain);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        mStatus = new ArrayList<>();

        readStatus();
//
//        search_status = view.findViewById(R.id.search_status);
//        search_status.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                searchUsers(charSequence.toString().toLowerCase());
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//
//            }
//        });

        return view;
    }

//    private void searchUsers(String s) {
//
//        final FirebaseUser fuser = FirebaseAuth.getInstance().getCurrentUser();
//        Query query = FirebaseDatabase.getInstance().getReference("Users").orderByChild("search")
//                .startAt(s)
//                .endAt(s+"\uf8ff");
//
//        query.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                mUsers.clear();
//                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
//                    User user = snapshot.getValue(User.class);
//
//                    assert user != null;
//                    assert fuser != null;
//                    if (!user.getId().equals(fuser.getUid())){
//                        mUsers.add(user);
//                    }
//                }
//
//                statusAdapter = new StatusAdapter(getContext(), mUsers, false);
//                recyclerView.setAdapter(statusAdapter);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//
//    }

    private void readStatus() {

//        final FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
//        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users");
//
//        reference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
////                if (search_status.getText().toString().equals("")) {
////                    mUsers.clear();
//                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                    Status status = snapshot.getValue(Status.class);
//
//                    if (!status.getId().equals(firebaseUser.getUid())) {
//                        mStatus.add(status);
//                    }
//                }
//
//                statusAdapter = new StatusAdapter(getContext(), mStatus, false);
//                recyclerView.setAdapter(statusAdapter);
//            }
////            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
    }
}