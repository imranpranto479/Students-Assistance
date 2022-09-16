package com.example.studentassistant;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.facebook.login.LoginManager;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

public class MenuActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.profile:
                startActivity(new Intent(MenuActivity.this, Profile.class));
                return true;
            case R.id.favorite:
startActivity(new Intent(MenuActivity.this,FavoriteList.class));

                return true;
            case R.id.logout:
                if (MainActivity.loginWithGoogle) {
                    GoogleSignInOptions gso = new GoogleSignInOptions.
                            Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).
                            build();

                    GoogleSignInClient googleSignInClient= GoogleSignIn.getClient(MenuActivity.this,gso);
                    googleSignInClient.signOut();
                    Toast.makeText(MenuActivity.this,"Log Out successfully",Toast.LENGTH_SHORT).show();
                    MainActivity.loginWithGoogle=false;
                    finishAffinity();
                    startActivity(new Intent(MenuActivity.this,MainActivity.class));



                }
                else {

                    LoginManager.getInstance().logOut();
                    Toast.makeText(MenuActivity.this, "Log Out successfully!", Toast.LENGTH_SHORT).show();
                    finishAffinity();
                    startActivity(new Intent(MenuActivity.this, MainActivity.class));

                }
                return true;

            case R.id.about:
                startActivity(new Intent(MenuActivity.this,About.class));
return true;

            default:
                return super.onOptionsItemSelected(item);


        }


    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }


}
