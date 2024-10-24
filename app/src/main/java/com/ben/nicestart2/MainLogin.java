package com.ben.nicestart2;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainLogin extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);





        //Glide for loading girls
        ImageView mGirl = findViewById(R.id.girl);


        Glide.with(this)
//                .load("https://images.unsplash.com/photo-1489424731084-a5d8b219a5bb?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1974&q=80")
                .load(R.drawable.girl)
                .transition(DrawableTransitionOptions.withCrossFade(500))
                .centerCrop()
                .into(mGirl);




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    //Metodo para abrir la actividad Signup
    public void openSignup(View view) {
        Intent intent = new Intent(this, Signup.class);
        startActivity(intent);
    }
    //Metodo para abrir la actividad Main
    public void openMainActivity(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}