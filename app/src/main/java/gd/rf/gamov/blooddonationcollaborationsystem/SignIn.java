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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.concurrent.Executor;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignIn extends Fragment {


    private static final String TAG = "";
    private View view;

    private EditText myEmail;
    private EditText myPassword;
    private TextView mySignup;
    private Button myLogin;

    public String email;
    private String password;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    public SignIn() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_sign_in, container, false);

        mAuth = FirebaseAuth.getInstance();


            mAuthListener = new FirebaseAuth.AuthStateListener() {
                @Override
                public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                    FirebaseUser user = firebaseAuth.getCurrentUser();
                    if (user != null) {
                        // User is signed in
                        Toast.makeText(getActivity(), user.getDisplayName(), Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                    } else {
                        // User is signed out
                        Toast.makeText(getActivity(), "yararar", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "onAuthStateChanged:signed_out");
                    }
                }
            };

        myLogin = (Button)view.findViewById(R.id.Login);
        mySignup = (TextView)view.findViewById(R.id.Signup);
        myEmail = (EditText)view.findViewById(R.id.UserEmail);
        myPassword = (EditText)view.findViewById(R.id.Password);

        myLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                email = myEmail.getText().toString();
                password = myPassword.getText().toString();

                getLogin(email,password);
            }
        });



        mySignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.Sign,new SignUp()).commit();
            }
        });


    return view;
    }


    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
        // ...
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
        // ...
    }

    public void getLogin(final String emails, String pass)
    {

        myEmail.setText("");
        myPassword.setText("");

        mAuth.signInWithEmailAndPassword(emails, pass)
                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "signInWithEmail:onComplete:" + task.isSuccessful());

                        Toast.makeText(getActivity(), "Success"+ mAuth.getCurrentUser().getDisplayName(), Toast.LENGTH_SHORT).show();

                        gotoact(emails);
                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "signInWithEmail:failed", task.getException());
                            Toast.makeText(getActivity(), "Failed", Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });


    }

    private void gotoact(String s) {

        Intent intent = new Intent(getActivity(),Feeds.class);
        intent.putExtra("Name", s);
        startActivity(intent);

    }

}
