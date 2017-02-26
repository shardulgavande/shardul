package com.example.monika.youtubetry1;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void click (View view){

        Intent i = new Intent(MainActivity.this, Playlist_view.class);
        i.putExtra("abc","Java");
        startActivity(i);
    }
//
    public void click1 (View view){

        Intent i = new Intent(MainActivity.this, Playlist_view.class);
        i.putExtra("abc","Android");
        startActivity(i);
    }
    public void click2 (View view){

        Intent i = new Intent(MainActivity.this, Playlist_view.class);
        i.putExtra("abc","Servlet");
        startActivity(i);
    }
    public void click3 (View view){

        Intent i = new Intent(MainActivity.this, Playlist_view.class);
        i.putExtra("abc","Msql");
        startActivity(i);
    }
    public void click4 (View view){

        Intent i = new Intent(MainActivity.this, Playlist_view.class);
        i.putExtra("abc","JDBC");
        startActivity(i);
    }
    public void click5 (View view){

        Intent i = new Intent(MainActivity.this, Playlist_view.class);
        i.putExtra("abc","Sql");
        startActivity(i);
    }
    public void click6 (View view){

        Intent i = new Intent(MainActivity.this, Playlist_view.class);
        i.putExtra("abc","Clang");
        startActivity(i);
    }

    public void click7(View view){
        Intent i = new Intent(MainActivity.this, Playlist_view.class);
        i.putExtra("abc","Collections");
        startActivity(i);
    }
    public void click8(View view){
        Intent i = new Intent(MainActivity.this, Playlist_view.class);
        i.putExtra("abc","Multi");
        startActivity(i);
    }
    public void click9 (View view){
        Intent i = new Intent(MainActivity.this, Playlist_view.class);
        i.putExtra("abc","Spring");
        startActivity(i);
    }
    public void click10 (View view){
        Intent i = new Intent(MainActivity.this, Playlist_view.class);
        i.putExtra("abc","Exception");
        startActivity(i);
    }
    public void click11 (View view){
        Intent i = new Intent(MainActivity.this, Playlist_view.class);
        i.putExtra("abc","MVC");
        startActivity(i);
    }
    public void click12 (View view){
        Intent i = new Intent(MainActivity.this, Playlist_view.class);
        i.putExtra("abc","XML");
        startActivity(i);
    }
    public void click13 (View view){
        Intent i = new Intent(MainActivity.this, Playlist_view.class);
        i.putExtra("abc","Inner");
        startActivity(i);
    }
    public void click14 (View view){
        Intent i = new Intent(MainActivity.this, Playlist_view.class);
        i.putExtra("abc","Enum");
        startActivity(i);
    }
    public void click15 (View view){
        Intent i = new Intent(MainActivity.this, Playlist_view.class);
        i.putExtra("abc","Java8");
        startActivity(i);
    }
    public void click16 (View view){
        Intent i = new Intent(MainActivity.this, Playlist_view.class);
        i.putExtra("abc","RMI");
        startActivity(i);
    }
    public void click17 (View view){
        Intent i = new Intent(MainActivity.this, Playlist_view.class);
        i.putExtra("abc","I18");
        startActivity(i);
    }
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (keyCode == KeyEvent.KEYCODE_BACK) {
//            onBackPressed();
//
//        }
//
//        return super.onKeyDown(keyCode, event);
//    }

    public void onBackPressed() {
        new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Exit")
                .setMessage("Are you sure?")
                .setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent intent = new Intent(Intent.ACTION_MAIN);
                        intent.addCategory(Intent.CATEGORY_HOME);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        finish();
                    }
                }).setPositiveButton("No", null).show();
    }
}