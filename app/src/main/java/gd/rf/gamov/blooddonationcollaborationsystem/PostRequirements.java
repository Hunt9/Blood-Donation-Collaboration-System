package gd.rf.gamov.blooddonationcollaborationsystem;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * A simple {@link Fragment} subclass.
 */
public class PostRequirements extends Fragment {

private View view;
    private Spinner myBloodGroups;
    private Spinner myUrgency;
    private Spinner myCountry;
    private Spinner myState;
    private Spinner myCity;
    private Spinner myHospital;
    private Spinner myRelation;

    private EditText myUnits;
    private EditText myContact;
    private EditText myInstructions;

    private Button myPost;

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mPostsDatabaseRefrence;

    private ChildEventListener mChildEventListner;


    public PostRequirements() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_post_requirements, container, false);

        mFirebaseDatabase = mFirebaseDatabase.getInstance();
        mPostsDatabaseRefrence = mFirebaseDatabase.getReference().child("Posts");

        myBloodGroups = (Spinner)view.findViewById(R.id.BGroup);
        myUrgency = (Spinner)view.findViewById(R.id.Urgency);
        myCountry = (Spinner)view.findViewById(R.id.Country);
        myState = (Spinner)view.findViewById(R.id.State);
        myCity = (Spinner)view.findViewById(R.id.City);
        myHospital = (Spinner)view.findViewById(R.id.Hospitals);
        myRelation = (Spinner)view.findViewById(R.id.Relation);

        myUnits = (EditText)view.findViewById(R.id.Units);
        myContact = (EditText)view.findViewById(R.id.Contact);
        myInstructions = (EditText)view.findViewById(R.id.Ainfo);

        myPost = (Button)view.findViewById(R.id.Post);
        myPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                UPosts posts = new UPosts("John",myBloodGroups.getSelectedItem().toString(),myUnits.getText().toString(),myUrgency.getSelectedItem().toString(),myCountry.getSelectedItem().toString(),myState.getSelectedItem().toString(),myCity.getSelectedItem().toString(),myHospital.getSelectedItem().toString(),myRelation.getSelectedItem().toString(),myContact.getText().toString(),myInstructions.getText().toString());
                mPostsDatabaseRefrence.push().setValue(posts);
                Toast.makeText(getActivity(), "Hogaya", Toast.LENGTH_SHORT).show();


            }
        });




    return view;
    }

}
