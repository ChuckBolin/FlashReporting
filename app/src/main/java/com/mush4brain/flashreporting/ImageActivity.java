package com.mush4brain.flashreporting;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;


public class ImageActivity extends Activity {

  private String TAG = "ImageActivity";
  FragmentTransaction ft = null;
  FragTop fragTop = new FragTop();
  FragBottom fragBottom = new FragBottom();
  FragLeft fragLeft = new FragLeft();
  FragRight fragRight = new FragRight();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

    //set action bar title and subtitle
    ActionBar actionBar = getActionBar();
    actionBar.setTitle("Flash Reporting v2015.08.01");
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy   HH:mm:ss");
    String dateString = formatter.format(new Date());
    actionBar.setSubtitle( dateString);

    ft = getFragmentManager().beginTransaction();
    ft.add(R.id.container_top, fragTop);
    ft.add(R.id.container_left,  fragLeft);
    ft.add(R.id.container_right, fragRight);
    ft.add(R.id.container_bottom, fragBottom);
    ft.commit();
  }

  //displays option menu
  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    MenuInflater menuInflater = getMenuInflater();
    menuInflater.inflate(R.menu.main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle item selection
    switch (item.getItemId()) {
      case R.id.sub:
        Toast.makeText(this, "Sub", Toast.LENGTH_SHORT).show();
        return true;
      case R.id.add:
        Toast.makeText(this, "Add",Toast.LENGTH_SHORT).show();
        return true;
      default:
        return super.onOptionsItemSelected(item);
    }
  }

  //************************************* FRAGMENT
  //top fragment
  public static class FragTop extends Fragment implements View.OnClickListener {
    public FragTop() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      View rootView = inflater
              .inflate(R.layout.container_top, container, false);
      return rootView;
    }

    @Override
    public void onClick(View v){
    }
  }

  //************************************* FRAGMENT
  //bottom fragment
  public static class FragBottom extends Fragment implements View.OnClickListener {
    public FragBottom() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      View rootView = inflater
              .inflate(R.layout.container_bottom, container, false);
      Button button1 = (Button)rootView.findViewById(R.id.buttonTest);
      button1.setOnClickListener(this);
      return rootView;
    }

    @Override
    public void onClick(View v){
      if (v.getId() == R.id.buttonTest){
        Toast.makeText(getActivity(), "Button test33", Toast.LENGTH_SHORT).show();
      }
    }
  }

  //************************************* FRAGMENT
  //left fragment
  public static class FragLeft extends Fragment implements View.OnClickListener{

    public FragLeft() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      View rootView = inflater
              .inflate(R.layout.container_left, container, false);
      return rootView;
    }

    @Override
    public void onClick(View v){
    }
  }

  //************************************* FRAGMENT
  //right fragment
  public static class FragRight extends Fragment implements View.OnClickListener {
    public FragRight() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      View rootView = inflater
              .inflate(R.layout.container_right, container, false);
      return rootView;
    }

    @Override
    public void onClick(View v){
    }
  }
}
