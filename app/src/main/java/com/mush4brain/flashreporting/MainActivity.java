package com.mush4brain.flashreporting;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

//http://www.androidinterview.com/android-custom-listview-with-image-and-text-using-arrayadapter/
//extends ListActivity
public class MainActivity extends Activity {//} implements View.OnClickListener {//} extends Activity implements View.OnClickListener {
  private String TAG = "MainActivity";
//  final int CAMERA_PIC_REQUEST = 1337;

  FragmentTransaction ft = null;
  FragMain fragMain = new FragMain();
  FragList fragList = new FragList();

//  ListView list;
  //ArrayList prgmName;
//  Integer [] imgid={R.drawable.ic_camera,R.drawable.ic_clear,
//          R.drawable.ic_damage,R.drawable.ic_flood,R.drawable.ic_funnel,
//          R.drawable.ic_hail,R.drawable.ic_history,R.drawable.ic_injury};//},
//  String[] itemname ={"Safari","Camera","Global","FireFox",
//          "UC Browser","Android Folder","VLC Player", "Cold War"
//  };
//  Integer [] imgid={R.drawable.ic_camera,R.drawable.ic_clear};
//  String[] itemname ={"Safari","Camera"};

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    //set action bar title and subtitle
    ActionBar actionBar = getActionBar();
    actionBar.setTitle("Flash Reporting v2015.08.01b");
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy   HH:mm:ss");
    String dateString = formatter.format(new Date());
    actionBar.setSubtitle(dateString);

    ft = getFragmentManager().beginTransaction();
    ft.add(R.id.container_fragmain, fragMain);
    ft.add(R.id.container_fraglist, fragList);
    ft.commit();
  }

//  @Override
//  public boolean onCreateOptionsMenu(Menu menu) {
//    // Inflate the menu; this adds items to the action bar if it is present.
//    getMenuInflater().inflate(R.menu.main, menu);
//    return true;
//  }

//  @Override
//  public boolean onOptionsItemSelected(MenuItem item) {
//    // Handle item selection
//    switch (item.getItemId()) {
//      case R.id.sub:
//        Toast.makeText(this, "Sub", Toast.LENGTH_SHORT).show();
//        return true;
//      case R.id.add:
//        Toast.makeText(this, "Add",Toast.LENGTH_SHORT).show();
//        return true;
//      default:
//        return super.onOptionsItemSelected(item);
//    }
//  }

  //************************************* FRAGMENT
  //main fragment
  public static class FragMain extends Fragment implements View.OnClickListener{

    public FragMain() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      View rootView = inflater
              .inflate(R.layout.container_fragmain, container, false);
      return rootView;
    }

    @Override
    public void onClick(View v){
    }
  }

  //************************************* FRAGMENT
  //list fragment
  public class FragList extends Fragment implements View.OnClickListener {
    Integer [] imgid={R.drawable.ic_camera,R.drawable.ic_clear};
    String[] itemname ={"Safari","Camera"};


    public FragList() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

   // CustomListAdapter adapter = new CustomListAdapter(getActivity(), itemname, imgid);


      //TODO this works
      View v = inflater.inflate(R.layout.container_fraglist, container, false);
      ListView lstItems = (ListView)v.findViewById(R.id.listView);
      ArrayList<String> prueba = new ArrayList<String>();
      prueba.add("Element1");
      prueba.add("Element2");
      prueba.add("Element3");
      ArrayAdapter<String> allItemsAdapter = new ArrayAdapter<String>(getActivity().getBaseContext(),
              android.R.layout.simple_list_item_1,prueba);
      lstItems.setAdapter(allItemsAdapter);
      return v;

      //TODO not working
//      View rootView = inflater
//              .inflate(R.layout.container_fraglist, container, false);
//      return rootView;
    }

    @Override
    public void onClick(View v){
    }
  }

}


//    CustomListAdapter adapter=new CustomListAdapter(this, itemname, imgid);
//    list = getListView();// (ListView)findViewById(R.id.list);
//    list.setAdapter(adapter);
//
//    list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//      @Override
//      public void onItemClick(AdapterView<?> parent, View view,
//                              int position, long id) {
//        // TODO Auto-generated method stub
//        String Selecteditem= itemname[+position];
//        Toast.makeText(getApplicationContext(), Selecteditem, Toast.LENGTH_SHORT).show();
//
//      }
//    });

//    View rootView = inflater
//            .inflate(R.layout.activity_main, container, false);
//    Button button = (Button) rootView.findViewById(R.id.buttonCamera);
//    button.setOnClickListener(this);


// //@Override
//  public void onClick(View v){
//    Toast.makeText(this,"Success", Toast.LENGTH_SHORT).show();
//    if(v.getId() == R.id.buttonSelectReport){// R.id.buttonCamera){
//      //call camera
//      Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
//      startActivityForResult(cameraIntent, CAMERA_PIC_REQUEST);
//    }
//  }
//
//  @Override
//  public void onActivityResult(int requestCode, int resultCode, Intent data) {
//
//    if (resultCode == RESULT_OK) {
//      if (requestCode == 1337) {
//        Bitmap bitmapThumbnail = (Bitmap) data.getExtras().get("data");
//        Toast.makeText(this,"Success", Toast.LENGTH_SHORT).show();
////        imageView.setImageBitmap(bitmapThumbnail);
////        collectData();
//
//      } else {
//        Log.d(TAG, "No image you big dummy");
//      }
//    }
//  }