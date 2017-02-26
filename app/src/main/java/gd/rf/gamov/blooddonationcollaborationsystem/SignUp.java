package gd.rf.gamov.blooddonationcollaborationsystem;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import static android.R.attr.fragment;
import static android.R.attr.password;
import static com.google.android.gms.internal.zzs.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignUp extends Fragment {

    private View view;
    private EditText myFirstName;
    private EditText myLastName;
    private EditText myEmail;
    private EditText myPassword;
    private Spinner myBloodGroup;
    private Button signup;

    private String fname;
    private String lname;
    private String email;
    private String pass;
    private String bgroup;


    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mUsersDatabaseRefrence;

//    private ChildEventListener mChildEventListner;
//
//    private FirebaseAuth mFirebaseAuth;
//    private FirebaseAuth.AuthStateListener mAuthStateListner;
//
//    private FirebaseStorage mFirebaseStorage;
//    private StorageReference mChatPhotoStorageReference;
//
//    private FirebaseRemoteConfig firebaseRemoteConfig;
//
//    private FirebaseMessagingService mFirebaseMessagingService;



    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    private Users userz;



    public SignUp() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_signup, container, false);


        mFirebaseDatabase = mFirebaseDatabase.getInstance();
        mUsersDatabaseRefrence = mFirebaseDatabase.getReference().child("Users");

        mAuth = FirebaseAuth.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
                // ...
            }
        };


        myFirstName = (EditText)view.findViewById(R.id.FirstName);
        myLastName = (EditText)view.findViewById(R.id.LastName);
        myEmail = (EditText)view.findViewById(R.id.Email);
        myPassword = (EditText)view.findViewById(R.id.Password);
        myBloodGroup = (Spinner)view.findViewById(R.id.SelectBloodGroup);
        signup = (Button)view.findViewById(R.id.SignUp);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fname = myFirstName.getText().toString();
                lname = myLastName.getText().toString();
                email = myEmail.getText().toString();
                pass = myPassword.getText().toString();
                bgroup = myBloodGroup.getSelectedItem().toString();

                mAuth.createUserWithEmailAndPassword(email,pass)
                        .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());

                                userz = new Users(fname,lname,email,bgroup);
                                mUsersDatabaseRefrence.push().setValue(userz);

                                Intent intent = new Intent(getActivity(), Feeds.class);
                                intent.putExtra("Name", mAuth.getCurrentUser().getDisplayName().toString());
                                startActivity(intent);



                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                                if (!task.isSuccessful()) {

                                    Toast.makeText(getActivity(), "hahahahaha", Toast.LENGTH_SHORT).show();

                                }


                            }
                        });


                myFirstName.setText("");
                myLastName.setText("");
                myEmail.setText("");
                myPassword.setText("");

            }
        });




    return view;
    }




    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }


}
