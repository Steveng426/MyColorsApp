package com.example.mycolorsapp;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    private SeekBar sbrRed=null;
    private SeekBar sbrGreen=null;
    private SeekBar sbrBlue=null;
    private SeekBar sbrAlpha=null;
    private View vieColors=null;
    private Toolbar tool=null;
    MenuItem acti2;

    public void ids(){//11
        sbrRed=findViewById(R.id.sbrRed);
        sbrGreen=findViewById(R.id.sbrGreen);
        sbrBlue=findViewById(R.id.sbrBlue);
        sbrAlpha=findViewById(R.id.sbrAlpha);
        vieColors=findViewById(R.id.vieColors);
    }
    public void changeColor(int r, int g, int b, int a, String idcolor){//10

        int color = Color.argb(a,r,g,b);
        ids();
        vieColors.setBackgroundColor(color);
        Toast.makeText(this, "You have selected the "+idcolor+ " option",Toast.LENGTH_SHORT ).show();
        sbrRed.setProgress(r);
        sbrBlue.setProgress(b);
        sbrGreen.setProgress(g);
        sbrAlpha.setProgress(a);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {//si1
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //3. set SeekBar change on moving
        ids();
        sbrRed.setOnSeekBarChangeListener(this);
        sbrGreen.setOnSeekBarChangeListener(this);
        sbrBlue.setOnSeekBarChangeListener(this);
        sbrAlpha.setOnSeekBarChangeListener(this);

        registerForContextMenu(vieColors);
        registerForContextMenu(vieColors);
        registerForContextMenu(vieColors);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean u) {//7
        int r= sbrRed.getProgress();
        int g= sbrGreen.getProgress();
        int b= sbrBlue.getProgress();
        int a= sbrAlpha.getProgress();

        int color= Color.argb(a,r,g,b);
        vieColors.setBackgroundColor(color);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {//8

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {//9

    }
    public boolean onCreateOptionsMenu(Menu menu) {//si2
        MenuInflater inflater=getMenuInflater();
        getMenuInflater().inflate(R.menu.colors1, menu);
        getMenuInflater().inflate(R.menu.reset, menu);
        getMenuInflater().inflate(R.menu.about, menu);
        return true;
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {//3
        switchcase(item);
        return super.onOptionsItemSelected(item);
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {//4
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.colors1,menu);
    }
    public boolean onContextItemSelected(@NonNull MenuItem item) {//5
        switchcase(item);
        return super.onContextItemSelected(item);
    }

    public boolean switchcase(MenuItem item) {//6
        switch(item.getItemId()){
            case R.id.iteYellow :
                changeColor(238,248,0,70,"Yellow");
                return true;
            case R.id.iteBlack :
                changeColor(0,0,0,200,"Black");
                return true;
            case R.id.iteBlue :
                changeColor(0,0,255,200,"Blue");
                return true;
            case R.id.iteRed :
                changeColor(255,0,0,200,"Red");
                return true;
            case R.id.iteBrown :
                changeColor(99,63,33,200,"Brown");
                return true;
            case R.id.iteGreen :
                changeColor(35,150,35,200,"Green");
                return true;
            case R.id.itePink :
                changeColor(200,50,130,200,"Pink");
                return true;
            case R.id.itePurple :
                changeColor(160,30,160,200,"Purple");
                return true;
            case R.id.iteGray :
                changeColor(120,120,120,200,"Gray");
                return true;
            case R.id.iteWhite :
                changeColor(255,255,0,0,"White");
                return true;
            case R.id.iteTransparent:
                changeColor(0,0,0,0,"transparent");
                return  true;
            case R.id.iteSemitransparent:
                changeColor(0,0,0,125,"semi transparent");
                return  true;
            case R.id.resetColors:
                changeColor(0,0,0,0,"null");
                return  true;
            case R.id.Aboutof:
                acti2.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        Intent acti2= new Intent(MainActivity.this, AboutActivity.class);
                        startActivity(acti2);
                        return true;
                    }
                } );
            default:
                return super.onContextItemSelected(item);
        }


    }
}
