package rechapi.bbps.bbpslibrary;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import rechapi.bbps.bbpslibrary.adapter.serviceCategoryAdapter;
import rechapi.bbps.bbpslibrary.fragment.Page1;
import rechapi.bbps.bbpslibrary.fragment.Page2;
import rechapi.bbps.bbpslibrary.model.SubCategoriesOne;
import rechapi.bbps.bbpslibrary.response.serviceCategoryResponse;
import rechapi.bbps.bbpslibrary.sharedPreferenceData.DataProccessor;
import rechapi.bbps.bbpslibrary.viewPager.ViewPagerAdapter;

public class bbpsServiceCategory extends AppCompatActivity implements Filterable {


    ArrayList<serviceCategoryResponse.DataList> listofurls;
    String personNames , strArraylist;
    String personImageshello,filteredListData ;
    Iterator itername;
    EditText search;
    serviceCategoryAdapter searchCityAdapter;
    WrapContentViewPager viewPager;
    ArrayList namelist=new ArrayList();
    ArrayList imagelist=new ArrayList();
    ViewPagerAdapter viewPagerAdapter;
    TabLayout tabLayout;
    TextView txtclear;
    String key;
    DataProccessor dataProccessor;
    String value;
    List<SubCategoriesOne> sublistdata,sublistdataone,sublistdatatwo;
    SubCategoriesOne sublistdata_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_mail);
          dataProccessor=new DataProccessor(getApplicationContext());
          String serviceCategory = getIntent().getStringExtra("serviceCategory");
          sublistdata=new ArrayList<>();
        sublistdataone=new ArrayList<>();
        sublistdatatwo=new ArrayList<>();

        viewPager = findViewById(R.id.viewpagersubcategory);
        tabLayout = findViewById(R.id.tabdotscabcatergory);
        search=(EditText) findViewById(R.id.editTextSearch);
        txtclear=(TextView)findViewById(R.id.clear);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        try {

            Log.d("SizeofData:-","hello"+serviceCategory.length());
            JSONObject issueObj = new JSONObject(serviceCategory);
            Log.e("totaldataSearchView","helloo:-"+issueObj.length());

            itername = issueObj.keys();
            while(itername.hasNext()) {
                 key = (String) itername.next(); //
                try {
                   // Object value = issueObj.get(key);
                     value = (String) issueObj.get(key);
                  //  personImageshello(value); // image

                } catch (JSONException e) {
                    // Something went wrong!
                }
             //   personNames.add(key); // name

                if (issueObj.get(key) instanceof JSONObject) {
                    // do something with jsonObject here
                }

                sublistdata_list=new SubCategoriesOne(getApplicationContext(),key, value);
                sublistdata.add(sublistdata_list);

            }

        } catch (JSONException e) {
            e.printStackTrace();
            Log.e("exceptionErrro:-","hello"+e);
        }

       for(int i=0;i<=sublistdata.size();i++){
           if(i<=11){
              /* viewPagerAdapter.add(new Page1(getApplicationContext(),sublistdata));
               viewPager.setAdapter(viewPagerAdapter);
               tabLayout.setupWithViewPager(viewPager, true);*/
               sublistdataone.add(sublistdata.get(i));
           }else if(i<=22 && i>=11) {
               sublistdatatwo.add(sublistdata.get(i));
           }
       }

        viewPagerAdapter.add(new Page1(getApplicationContext(),sublistdataone));
        viewPagerAdapter.add(new Page2(getApplicationContext(),sublistdatatwo));
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager, true);
    }




    private void setAdapter(ArrayList<serviceCategoryResponse.DataList> list) {
        if (list == null || list.size() == 0) {
            return;
        }
    }

    @Override
    public Filter getFilter() {

        return filter;
    }

    Filter filter=new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {

            FilterResults filterResults=new FilterResults();

            if(charSequence==null || charSequence.length()==0){
                filterResults.count=sublistdata.size();
                filterResults.values=sublistdata;
            }else {
                String str=charSequence.toString().toLowerCase();

            }
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

        }
    };

}
