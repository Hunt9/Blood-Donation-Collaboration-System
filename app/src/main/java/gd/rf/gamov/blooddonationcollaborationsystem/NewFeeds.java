package gd.rf.gamov.blooddonationcollaborationsystem;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewFeeds extends Fragment {


    private View view;


    private feedAdapter feedAdapterz;

    private ListView feeds;

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mMessageDatabaseRefrence;

    private ChildEventListener mChildEventListner;



    public NewFeeds() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_new_feeds, container, false);

        feeds = (ListView)view.findViewById(R.id.FEEDSSList);

        mFirebaseDatabase = mFirebaseDatabase.getInstance();

        List<UPosts> post1 = new ArrayList<>();
        feedAdapterz = new feedAdapter(getActivity(), R.layout.feedlist, post1);
        feeds.setAdapter(feedAdapterz);


        mMessageDatabaseRefrence = mFirebaseDatabase.getReference().child("Posts");


        mChildEventListner = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                UPosts postx = dataSnapshot.getValue(UPosts.class);
                feedAdapterz.add(postx);


            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        };

        mMessageDatabaseRefrence.addChildEventListener(mChildEventListner);




    return view;
    }



}
