package com.mush4brain.flashreporting;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

//http://www.androidinterview.com/android-custom-listview-with-image-and-text-using-arrayadapter/
public class MainActivity extends ListActivity {//} extends Activity implements View.OnClickListener {
  private String TAG = "MainActivity";

  ListView list;
  ArrayList prgmName;
  Integer [] imgid={R.drawable.ic_camera,R.drawable.ic_clear,
          R.drawable.ic_damage,R.drawable.ic_flood,R.drawable.ic_funnel,
          R.drawable.ic_hail,R.drawable.ic_history,R.drawable.ic_injury};//},
  String[] itemname ={"Safari","Camera","Global","FireFox",
          "UC Browser","Android Folder","VLC Player", "Cold War"
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    CustomListAdapter adapter=new CustomListAdapter(this, itemname, imgid);
    list = getListView();// (ListView)findViewById(R.id.list);
    list.setAdapter(adapter);

    list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

      @Override
      public void onItemClick(AdapterView<?> parent, View view,
                              int position, long id) {
        // TODO Auto-generated method stub
        String Selecteditem= itemname[+position];
        Toast.makeText(getApplicationContext(), Selecteditem, Toast.LENGTH_SHORT).show();

      }
    });

  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main, menu);
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
}

//Button mButtonImage;
//
//  @Override
//  protected void onCreate(Bundle savedInstanceState) {
//    super.onCreate(savedInstanceState);
//    setContentView(R.layout.activity_main);
//
//    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//
//    //set action bar title and subtitle
//    ActionBar actionBar = getActionBar();
//    actionBar.setTitle("Flash Reporting v2015.08.01b");
//    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy   HH:mm:ss");
//    String dateString = formatter.format(new Date());
//    actionBar.setSubtitle( dateString);
//
//    mButtonImage = (Button)findViewById(R.id.buttonImageActivity);
//    mButtonImage.setOnClickListener(this);
//  }
//
//  //buttonImageActivity
//  @Override
//  public void onClick(View v){
//    if(v.getId() == R.id.buttonImageActivity){
////      Intent intent = new Intent(this, ImageActivity.class);
////      startActivity(intent);
//    }
//  }
//
//  //displays option menu
//  @Override
//  public boolean onCreateOptionsMenu(Menu menu) {
//    // Inflate the menu; this adds items to the action bar if it is present.
//    MenuInflater menuInflater = getMenuInflater();
//    menuInflater.inflate(R.menu.main, menu);
//    return true;
//  }
//
//  @Override
//  public boolean onOptionsItemSelected(MenuItem item) {
//    // Handle item selection
//    switch (item.getItemId()) {
//      case R.id.sub:
//        Toast.makeText(this, "Sub",Toast.LENGTH_SHORT).show();
//        return true;
//      case R.id.add:
//        Toast.makeText(this, "Add",Toast.LENGTH_SHORT).show();
//        return true;
//      default:
//        return super.onOptionsItemSelected(item);
//    }
//  }