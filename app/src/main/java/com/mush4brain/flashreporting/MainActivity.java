package com.mush4brain.flashreporting;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity {
  private String TAG = "MainActivity";
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


    ft = getFragmentManager().beginTransaction();
    ft.add(R.id.container_top, fragTop);
    ft.add(R.id.container_left,  fragLeft);
    ft.add(R.id.container_right, fragRight);
    ft.add(R.id.container_bottom, fragBottom);
    ft.commit();
  }

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

//    public void testButtonClick() {
//      Toast.makeText(getActivity(), "Button test2", Toast.LENGTH_SHORT);
//    }
    @Override
    public void onClick(View v){
      if (v.getId() == R.id.buttonTest){
        Toast.makeText(getActivity(), "Button test33", Toast.LENGTH_SHORT).show();


      }
//      Toast.makeText(getActivity(), "Button test", Toast.LENGTH_SHORT);
    }


  }

  //left fragment
  public static class FragLeft extends Fragment implements View.OnClickListener {
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
