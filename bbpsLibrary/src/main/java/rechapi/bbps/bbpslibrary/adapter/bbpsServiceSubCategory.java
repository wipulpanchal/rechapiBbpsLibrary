package rechapi.bbps.bbpslibrary.adapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import com.google.android.material.tabs.TabLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import rechapi.bbps.bbpslibrary.R;
import rechapi.bbps.bbpslibrary.fragment.pageSubCategoryEight;
import rechapi.bbps.bbpslibrary.fragment.pageSubCategoryEighteen;
import rechapi.bbps.bbpslibrary.fragment.pageSubCategoryEleven;
import rechapi.bbps.bbpslibrary.fragment.pageSubCategoryFifteen;
import rechapi.bbps.bbpslibrary.fragment.pageSubCategoryFive;
import rechapi.bbps.bbpslibrary.fragment.pageSubCategoryFour;
import rechapi.bbps.bbpslibrary.fragment.pageSubCategoryNine;
import rechapi.bbps.bbpslibrary.fragment.pageSubCategoryNinteen;
import rechapi.bbps.bbpslibrary.fragment.pageSubCategoryOne;
import rechapi.bbps.bbpslibrary.fragment.pageSubCategorySeven;
import rechapi.bbps.bbpslibrary.fragment.pageSubCategorySeventeen;
import rechapi.bbps.bbpslibrary.fragment.pageSubCategorySix;
import rechapi.bbps.bbpslibrary.fragment.pageSubCategorySixteen;
import rechapi.bbps.bbpslibrary.fragment.pageSubCategoryTen;
import rechapi.bbps.bbpslibrary.fragment.pageSubCategoryThirteen;
import rechapi.bbps.bbpslibrary.fragment.pageSubCategoryThree;
import rechapi.bbps.bbpslibrary.fragment.pageSubCategoryTwelve;
import rechapi.bbps.bbpslibrary.fragment.pageSubCategoryTwo;
import rechapi.bbps.bbpslibrary.fragment.pageSubCategoryfourteen;
import rechapi.bbps.bbpslibrary.response.serviceCategoryResponse;
import rechapi.bbps.bbpslibrary.sharedPreferenceData.DataProccessor;
import rechapi.bbps.bbpslibrary.viewPager.ViewPagerAdapter;

public class bbpsServiceSubCategory extends AppCompatActivity {


    ArrayList personNames ;
    ArrayList personImageshello;

    ViewPagerAdapter viewPagerAdapter;
    TabLayout tabLayout;
    ViewPager viewPager;
    DataProccessor dataProccessor;
    SharedPreferences sharedPreferences;
    private  static  final  String shared_pref_name="myPref";
    JSONObject issueObj;
    String serviceCategory;
    EditText etxtSearch;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bbps_service_sub_category);
        sharedPreferences=getApplicationContext().getSharedPreferences(shared_pref_name,MODE_PRIVATE);
        personImageshello = new ArrayList<>(Arrays.asList());
        personNames = new ArrayList<>(Arrays.asList());
        dataProccessor=new DataProccessor(getApplicationContext());
        viewPager=(ViewPager)findViewById(R.id.viewpager_subcategory_two);
        tabLayout = findViewById(R.id.tab_dot_lyt_sub_cat);

       // etxtSearch=(EditText)findViewById(R.id.search_box_sib_cat);

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        if(sharedPreferences!=null){
            serviceCategory=sharedPreferences.getString("dataSubCat",null);
        }else {
            Log.d("dataIsNull:-","nullSharedPreference"+sharedPreferences);
        }

        Log.d("he","hiiiii"+serviceCategory);
        Log.d("hel:-","hiiiii"+serviceCategory.length());

        try {
             issueObj = new JSONObject(serviceCategory);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Log.d("HelloBuddy","heeelo"+issueObj.length());


        if(issueObj.length()<=9){
            viewPagerAdapter.add(new pageSubCategoryOne());
        }else if(issueObj.length()<=18){
            viewPagerAdapter.add(new pageSubCategoryOne());
            viewPagerAdapter.add(new pageSubCategoryTwo());
        }else if(issueObj.length()<=27){
            viewPagerAdapter.add(new pageSubCategoryOne());
            viewPagerAdapter.add(new pageSubCategoryTwo());
            viewPagerAdapter.add(new pageSubCategoryThree());
        }else if(issueObj.length()<=36){
            viewPagerAdapter.add(new pageSubCategoryOne());
            viewPagerAdapter.add(new pageSubCategoryTwo());
            viewPagerAdapter.add(new pageSubCategoryThree());
            viewPagerAdapter.add(new pageSubCategoryFour());
        }else if(issueObj.length()<=45){
            viewPagerAdapter.add(new pageSubCategoryOne());
            viewPagerAdapter.add(new pageSubCategoryTwo());
            viewPagerAdapter.add(new pageSubCategoryThree());
            viewPagerAdapter.add(new pageSubCategoryFour());
            viewPagerAdapter.add(new pageSubCategoryFive());
        }else if(issueObj.length()<=54) {
            viewPagerAdapter.add(new pageSubCategoryOne());
            viewPagerAdapter.add(new pageSubCategoryTwo());
            viewPagerAdapter.add(new pageSubCategoryThree());
            viewPagerAdapter.add(new pageSubCategoryFour());
            viewPagerAdapter.add(new pageSubCategoryFive());
            viewPagerAdapter.add(new pageSubCategorySix());
        }else if(issueObj.length()<=63) {
            viewPagerAdapter.add(new pageSubCategoryOne());
            viewPagerAdapter.add(new pageSubCategoryTwo());
            viewPagerAdapter.add(new pageSubCategoryThree());
            viewPagerAdapter.add(new pageSubCategoryFour());
            viewPagerAdapter.add(new pageSubCategoryFive());
            viewPagerAdapter.add(new pageSubCategorySix());
            viewPagerAdapter.add(new pageSubCategorySeven());
        }else if(issueObj.length()<=72) {
            viewPagerAdapter.add(new pageSubCategoryOne());
            viewPagerAdapter.add(new pageSubCategoryTwo());
            viewPagerAdapter.add(new pageSubCategoryThree());
            viewPagerAdapter.add(new pageSubCategoryFour());
            viewPagerAdapter.add(new pageSubCategoryFive());
            viewPagerAdapter.add(new pageSubCategorySix());
            viewPagerAdapter.add(new pageSubCategorySeven());
            viewPagerAdapter.add(new pageSubCategoryEight());
        }else if(issueObj.length()<=81) {
            viewPagerAdapter.add(new pageSubCategoryOne());
            viewPagerAdapter.add(new pageSubCategoryTwo());
            viewPagerAdapter.add(new pageSubCategoryThree());
            viewPagerAdapter.add(new pageSubCategoryFour());
            viewPagerAdapter.add(new pageSubCategoryFive());
            viewPagerAdapter.add(new pageSubCategorySix());
            viewPagerAdapter.add(new pageSubCategorySeven());
            viewPagerAdapter.add(new pageSubCategoryEight());
            viewPagerAdapter.add(new pageSubCategoryNine());
        }else if(issueObj.length()<=90) {
            viewPagerAdapter.add(new pageSubCategoryOne());
            viewPagerAdapter.add(new pageSubCategoryTwo());
            viewPagerAdapter.add(new pageSubCategoryThree());
            viewPagerAdapter.add(new pageSubCategoryFour());
            viewPagerAdapter.add(new pageSubCategoryFive());
            viewPagerAdapter.add(new pageSubCategorySix());
            viewPagerAdapter.add(new pageSubCategorySeven());
            viewPagerAdapter.add(new pageSubCategoryEight());
            viewPagerAdapter.add(new pageSubCategoryNine());
            viewPagerAdapter.add(new pageSubCategoryTen());
        }else if(issueObj.length()<=99) {
            viewPagerAdapter.add(new pageSubCategoryOne());
            viewPagerAdapter.add(new pageSubCategoryTwo());
            viewPagerAdapter.add(new pageSubCategoryThree());
            viewPagerAdapter.add(new pageSubCategoryFour());
            viewPagerAdapter.add(new pageSubCategoryFive());
            viewPagerAdapter.add(new pageSubCategorySix());
            viewPagerAdapter.add(new pageSubCategorySeven());
            viewPagerAdapter.add(new pageSubCategoryEight());
            viewPagerAdapter.add(new pageSubCategoryNine());
            viewPagerAdapter.add(new pageSubCategoryTen());
            viewPagerAdapter.add(new pageSubCategoryEleven());
        }else if(issueObj.length()<=108) {
            viewPagerAdapter.add(new pageSubCategoryOne());
            viewPagerAdapter.add(new pageSubCategoryTwo());
            viewPagerAdapter.add(new pageSubCategoryThree());
            viewPagerAdapter.add(new pageSubCategoryFour());
            viewPagerAdapter.add(new pageSubCategoryFive());
            viewPagerAdapter.add(new pageSubCategorySix());
            viewPagerAdapter.add(new pageSubCategorySeven());
            viewPagerAdapter.add(new pageSubCategoryEight());
            viewPagerAdapter.add(new pageSubCategoryNine());
            viewPagerAdapter.add(new pageSubCategoryTen());
            viewPagerAdapter.add(new pageSubCategoryEleven());
            viewPagerAdapter.add(new pageSubCategoryTwelve());
        }else if(issueObj.length()<=117) {
            viewPagerAdapter.add(new pageSubCategoryOne());
            viewPagerAdapter.add(new pageSubCategoryTwo());
            viewPagerAdapter.add(new pageSubCategoryThree());
            viewPagerAdapter.add(new pageSubCategoryFour());
            viewPagerAdapter.add(new pageSubCategoryFive());
            viewPagerAdapter.add(new pageSubCategorySix());
            viewPagerAdapter.add(new pageSubCategorySeven());
            viewPagerAdapter.add(new pageSubCategoryEight());
            viewPagerAdapter.add(new pageSubCategoryNine());
            viewPagerAdapter.add(new pageSubCategoryTen());
            viewPagerAdapter.add(new pageSubCategoryEleven());
            viewPagerAdapter.add(new pageSubCategoryTwelve());
            viewPagerAdapter.add(new pageSubCategoryThirteen());
        }else if(issueObj.length()<=126) {
            viewPagerAdapter.add(new pageSubCategoryOne());
            viewPagerAdapter.add(new pageSubCategoryTwo());
            viewPagerAdapter.add(new pageSubCategoryThree());
            viewPagerAdapter.add(new pageSubCategoryFour());
            viewPagerAdapter.add(new pageSubCategoryFive());
            viewPagerAdapter.add(new pageSubCategorySix());
            viewPagerAdapter.add(new pageSubCategorySeven());
            viewPagerAdapter.add(new pageSubCategoryEight());
            viewPagerAdapter.add(new pageSubCategoryNine());
            viewPagerAdapter.add(new pageSubCategoryTen());
            viewPagerAdapter.add(new pageSubCategoryEleven());
            viewPagerAdapter.add(new pageSubCategoryTwelve());
            viewPagerAdapter.add(new pageSubCategoryThirteen());
            viewPagerAdapter.add(new pageSubCategoryfourteen());
        }else if(issueObj.length()<=135) {
            viewPagerAdapter.add(new pageSubCategoryOne());
            viewPagerAdapter.add(new pageSubCategoryTwo());
            viewPagerAdapter.add(new pageSubCategoryThree());
            viewPagerAdapter.add(new pageSubCategoryFour());
            viewPagerAdapter.add(new pageSubCategoryFive());
            viewPagerAdapter.add(new pageSubCategorySix());
            viewPagerAdapter.add(new pageSubCategorySeven());
            viewPagerAdapter.add(new pageSubCategoryEight());
            viewPagerAdapter.add(new pageSubCategoryNine());
            viewPagerAdapter.add(new pageSubCategoryTen());
            viewPagerAdapter.add(new pageSubCategoryEleven());
            viewPagerAdapter.add(new pageSubCategoryTwelve());
            viewPagerAdapter.add(new pageSubCategoryThirteen());
            viewPagerAdapter.add(new pageSubCategoryfourteen());
            viewPagerAdapter.add(new pageSubCategoryFifteen());
        }else if(issueObj.length()<=144) {
            viewPagerAdapter.add(new pageSubCategoryOne());
            viewPagerAdapter.add(new pageSubCategoryTwo());
            viewPagerAdapter.add(new pageSubCategoryThree());
            viewPagerAdapter.add(new pageSubCategoryFour());
            viewPagerAdapter.add(new pageSubCategoryFive());
            viewPagerAdapter.add(new pageSubCategorySix());
            viewPagerAdapter.add(new pageSubCategorySeven());
            viewPagerAdapter.add(new pageSubCategoryEight());
            viewPagerAdapter.add(new pageSubCategoryNine());
            viewPagerAdapter.add(new pageSubCategoryTen());
            viewPagerAdapter.add(new pageSubCategoryEleven());
            viewPagerAdapter.add(new pageSubCategoryTwelve());
            viewPagerAdapter.add(new pageSubCategoryThirteen());
            viewPagerAdapter.add(new pageSubCategoryfourteen());
            viewPagerAdapter.add(new pageSubCategoryFifteen());
            viewPagerAdapter.add(new pageSubCategorySixteen());
        }else if(issueObj.length()<=153) {
            viewPagerAdapter.add(new pageSubCategoryOne());
            viewPagerAdapter.add(new pageSubCategoryTwo());
            viewPagerAdapter.add(new pageSubCategoryThree());
            viewPagerAdapter.add(new pageSubCategoryFour());
            viewPagerAdapter.add(new pageSubCategoryFive());
            viewPagerAdapter.add(new pageSubCategorySix());
            viewPagerAdapter.add(new pageSubCategorySeven());
            viewPagerAdapter.add(new pageSubCategoryEight());
            viewPagerAdapter.add(new pageSubCategoryNine());
            viewPagerAdapter.add(new pageSubCategoryTen());
            viewPagerAdapter.add(new pageSubCategoryEleven());
            viewPagerAdapter.add(new pageSubCategoryTwelve());
            viewPagerAdapter.add(new pageSubCategoryThirteen());
            viewPagerAdapter.add(new pageSubCategoryfourteen());
            viewPagerAdapter.add(new pageSubCategoryFifteen());
            viewPagerAdapter.add(new pageSubCategorySixteen());
            viewPagerAdapter.add(new pageSubCategorySeventeen());
        }else if(issueObj.length()<=162) {
            viewPagerAdapter.add(new pageSubCategoryOne());
            viewPagerAdapter.add(new pageSubCategoryTwo());
            viewPagerAdapter.add(new pageSubCategoryThree());
            viewPagerAdapter.add(new pageSubCategoryFour());
            viewPagerAdapter.add(new pageSubCategoryFive());
            viewPagerAdapter.add(new pageSubCategorySix());
            viewPagerAdapter.add(new pageSubCategorySeven());
            viewPagerAdapter.add(new pageSubCategoryEight());
            viewPagerAdapter.add(new pageSubCategoryNine());
            viewPagerAdapter.add(new pageSubCategoryTen());
            viewPagerAdapter.add(new pageSubCategoryEleven());
            viewPagerAdapter.add(new pageSubCategoryTwelve());
            viewPagerAdapter.add(new pageSubCategoryThirteen());
            viewPagerAdapter.add(new pageSubCategoryfourteen());
            viewPagerAdapter.add(new pageSubCategoryFifteen());
            viewPagerAdapter.add(new pageSubCategorySixteen());
            viewPagerAdapter.add(new pageSubCategorySeventeen());
            viewPagerAdapter.add(new pageSubCategoryEighteen());
        }else if(issueObj.length()<=175) {
            viewPagerAdapter.add(new pageSubCategoryOne());
            viewPagerAdapter.add(new pageSubCategoryTwo());
            viewPagerAdapter.add(new pageSubCategoryThree());
            viewPagerAdapter.add(new pageSubCategoryFour());
            viewPagerAdapter.add(new pageSubCategoryFive());
            viewPagerAdapter.add(new pageSubCategorySix());
            viewPagerAdapter.add(new pageSubCategorySeven());
            viewPagerAdapter.add(new pageSubCategoryEight());
            viewPagerAdapter.add(new pageSubCategoryNine());
            viewPagerAdapter.add(new pageSubCategoryTen());
            viewPagerAdapter.add(new pageSubCategoryEleven());
            viewPagerAdapter.add(new pageSubCategoryTwelve());
            viewPagerAdapter.add(new pageSubCategoryThirteen());
            viewPagerAdapter.add(new pageSubCategoryfourteen());
            viewPagerAdapter.add(new pageSubCategoryFifteen());
            viewPagerAdapter.add(new pageSubCategorySixteen());
            viewPagerAdapter.add(new pageSubCategorySeventeen());
            viewPagerAdapter.add(new pageSubCategoryEighteen());
            viewPagerAdapter.add(new pageSubCategoryNinteen());
        }

       /* viewPagerAdapter.add(new pageSubCategoryOne());
        viewPagerAdapter.add(new pageSubCategoryTwo());*/


        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager, true);

    }



}