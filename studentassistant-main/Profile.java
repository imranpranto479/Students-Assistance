package com.example.studentassistant;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.squareup.picasso.Picasso;

public class Profile extends MenuActivity {
ImageView profileImage;
TextView profileName,thirdInfo,secInfo;
public static GoogleApiClient googleApiClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        setTitle("Profile");

        profileImage=findViewById(R.id.image);
        profileName =findViewById(R.id.name);
        thirdInfo=findViewById(R.id.thirdInfo);
        secInfo=findViewById(R.id.secInfo);


            if (!MainActivity.loginWithGoogle){
                Picasso.get().load(MainActivity.fbImageUrl).into(profileImage);
                profileName.setText("Name: "+MainActivity.fbName);
                secInfo.setText("Email: "+MainActivity.fbEmail);
                thirdInfo.setText("gender: "+MainActivity.fbGender);

            }





    }
    public void setInformation(GoogleSignInResult result){
        if (result.isSuccess()){
            GoogleSignInAccount account=result.getSignInAccount();
            profileName.setText("Name: "+account.getDisplayName());
            Picasso.get().load(account.getPhotoUrl()).into(profileImage);
            secInfo.setText("Email: "+account.getEmail());
            thirdInfo.setText("Family name: "+account.getFamilyName());


        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        OptionalPendingResult<GoogleSignInResult> option= Auth.GoogleSignInApi.silentSignIn(googleApiClient);
        if (option.isDone()){
            GoogleSignInResult result=option.get();
            setInformation(result);

        }
    }



}