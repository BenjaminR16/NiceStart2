package com.ben.nicestart2;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainVista extends AppCompatActivity {

    private TextView mycontext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_vista);

        mycontext = findViewById(R.id.vistaweb);
        registerForContextMenu(mycontext);




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    //menu desplegable
    @Override
    public void onCreateContextMenu(ContextMenu menu, View view,ContextMenu.ContextMenuInfo menuInfo){
        getMenuInflater().inflate(R.menu.menu_context, menu);
    }

    //funcionalidad menu_context
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.item1) {
            Toast.makeText(this, "Item copied", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.item2) {
            Toast.makeText(this, "Dowloading Item...", Toast.LENGTH_SHORT).show();
            return true;
        }

    /*
        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(this, "Item copied", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.item2:
                Toast.makeText(this, "Dowloading Item...", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return false;
        }
    */
        return false;
    }

    //declara el menu desplegable
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_appbar, menu);
        return true;
    }

    //funcionalidad menu_appbar
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == R.id.item3){
            Toast.makeText(this, "Infecting", Toast.LENGTH_SHORT).show();
        }else if(id == R.id.item4){
            Intent intent = new Intent(MainVista.this, MainLogin.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}