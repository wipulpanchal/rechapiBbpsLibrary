package rechapi.bbps.bbpslibrary;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

import rechapi.bbps.bbpslibrary.adapter.ImageAdapter;

public class bbpsServiceList extends Activity {


    GridView gridView;

    static final String[] MOBILE_OS = new String[] {
            "Android", "iOS","Windows", "Blackberry","Android", "iOS","Windows", "Blackberry" };

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ArrayList<String> aList = new ArrayList<String>();
        aList.add("Android");
        aList.add("Ios");

        gridView = (GridView) findViewById(R.id.gridView1);

        gridView.setAdapter(new ImageAdapter(this, MOBILE_OS));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Log.d("MainActivity","clicked "+position);

            }
        });

    }
}
