package com.mush4brain.flashreporting;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

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
    setContentView(R.layout.activity_image);

    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

    //set action bar title and subtitle
    ActionBar actionBar = getActionBar();
    actionBar.setTitle("Flash Reporting v2015.08.01x");
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
    final int CAMERA_PIC_REQUEST = 1337;
    private String TAG = "ImageActivityFragBottom";

    public FragBottom() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      View rootView = inflater
              .inflate(R.layout.container_bottom, container, false);
      Button button2 = (Button) rootView.findViewById(R.id.buttonCamera);
      button2.setOnClickListener(this);
      return rootView;
    }

    @Override
    public void onClick(View v) {
      if (v.getId() == R.id.buttonCamera) {
//        Toast.makeText(getActivity(), "Button camera", Toast.LENGTH_SHORT).show();
        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, CAMERA_PIC_REQUEST);
      }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

      if (resultCode == RESULT_OK) {
        if (requestCode == 1337) {
          //Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
//          mThumbnail = (Bitmap) data.getExtras().get("data");
//          mImageView.setImageBitmap(mThumbnail);

        } else {
          Log.d(TAG, "No image you big dummy");
        }
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
