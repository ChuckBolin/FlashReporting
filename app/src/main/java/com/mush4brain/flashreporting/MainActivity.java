package com.mush4brain.flashreporting;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
public class MainActivity extends Activity implements View.OnClickListener {
  private String TAG = "MainActivity";
  Button mButtonImage;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

    //set action bar title and subtitle
    ActionBar actionBar = getActionBar();
    actionBar.setTitle("Flash Reporting v2015.08.01b");
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy   HH:mm:ss");
    String dateString = formatter.format(new Date());
    actionBar.setSubtitle( dateString);

    mButtonImage = (Button)findViewById(R.id.buttonImageActivity);
    mButtonImage.setOnClickListener(this);
  }

  //buttonImageActivity
  @Override
  public void onClick(View v){
    if(v.getId() == R.id.buttonImageActivity){
      Intent intent = new Intent(this, ImageActivity.class);
      startActivity(intent);
    }
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
        Toast.makeText(this, "Sub",Toast.LENGTH_SHORT).show();
        return true;
      case R.id.add:
        Toast.makeText(this, "Add",Toast.LENGTH_SHORT).show();
        return true;
      default:
        return super.onOptionsItemSelected(item);
    }
  }

}
