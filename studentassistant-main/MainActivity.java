package com.example.studentassistant;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {
SignInButton signIn;
public GoogleApiClient googleApiClient;
static final int signin=1;
LoginButton fbLoginButton;
public static LoginResult fbLoginResult;
    CallbackManager callbackManager;
    public static boolean loginWithGoogle=false;
 public static String fbName,fbImageUrl,fbGender,fbEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // signIn=findViewById(R.id.google_login);
       GoogleSignInOptions gso=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();

        googleApiClient =new GoogleApiClient.Builder(this).enableAutoManage(this,this).addApi(Auth.GOOGLE_SIGN_IN_API,gso).build();
        signIn=findViewById(R.id.google_login);

        Profile.googleApiClient=googleApiClient;
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
                startActivityForResult(intent,signin);

            }
        });

        fbLoginButton=findViewById(R.id.fbLoginButton);
         callbackManager=CallbackManager.Factory.create();
         fbLoginButton.setPermissions(Arrays.asList("user_gender","email","user_photos","public_profile","user_friends"));

        fbLoginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {

            @Override
            public void onSuccess(LoginResult loginResult) {

                fbLoginResult=loginResult;
                startActivity(new Intent(MainActivity.this,Home.class));

                //Picasso.get().load("https://graph.facebook.com/" + loginResult.getAccessToken().getUserId()+ "/picture?type=large").into(profileImage);

                GraphRequest graphRequest=GraphRequest.newMeRequest(AccessToken.getCurrentAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        if (response!=null) {
                            try {
                                fbName = object.getString("name");
                                String id = object.getString("id");
                                fbImageUrl = "https://graph.facebook.com/" + id + "/picture?type=large";
                                fbEmail = object.getString("email");
                                fbGender = object.getString("gender");


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }


                    }
                });
                Bundle bundle=new Bundle();
                bundle.putString("fields","name, email, gender, id");
                graphRequest.setParameters(bundle);
                graphRequest.executeAsync();
                finish();
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });

    }
    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

   @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
       super.onActivityResult(requestCode, resultCode, data);

           callbackManager.onActivityResult(requestCode, resultCode, data);

           if (requestCode == signin) {

               GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
               if (result.isSuccess()) {
                   loginWithGoogle=true;
                   startActivity(new Intent(MainActivity.this, Home.class));
                   finish();
               } else {
                   Toast.makeText(this, "login failed!", Toast.LENGTH_SHORT).show();

               }
           } //else Toast.makeText(this, "login failed", Toast.LENGTH_SHORT).show();


      // graphRequest.executeAndWait();





   }


}