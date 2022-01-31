package rechapi.bbps.bbpslibrary.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import rechapi.bbps.bbpslibrary.R;
import rechapi.bbps.bbpslibrary.adapter.serviceCategoryAdapter;
import rechapi.bbps.bbpslibrary.model.SubCategoriesOne;

public class Page1 extends Fragment  {

    ArrayList personNames ;
    ArrayList personImageshello ,personImagesone,personImagetwo,personnameone,personnametwo;
    Iterator itername;
    RecyclerView recyclerView;

     Context context;
    List<SubCategoriesOne> sublistdata;



    public Page1(Context applicationContext, List<SubCategoriesOne> sublistdataone) {
        this.context=applicationContext;
        this.sublistdata=sublistdataone;
    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
 
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.fragmentpage1,container,false);
       //
       /* personImageshello = new ArrayList<>(Arrays.asList());
        personImagesone = new ArrayList<>(Arrays.asList());
        personImagetwo = new ArrayList<>(Arrays.asList());
        personNames = new ArrayList<>(Arrays.asList());
        personnameone = new ArrayList<>(Arrays.asList());
        personnametwo = new ArrayList<>(Arrays.asList());*/


        // get the reference of RecyclerView
         recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewfragmnetone);
        // set a GridLayoutManager with default vertical orientation and 2 number of columns
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),4);
        recyclerView.setLayoutManager(gridLayoutManager); // set LayoutManager to RecyclerView

        //  call the constructor of CustomAdapter to send the reference and data to Adapter
     //   serviceCategoryAdapter customAdapter = new serviceCategoryAdapter(getContext(), personNames,personImageshello);

      //  customAdapter = new serviceCategoryAdapter(getContext(), personnameone,personImagesone);

        serviceCategoryAdapter customAdapter = new serviceCategoryAdapter(getContext(), sublistdata);

        Log.d("hellolistdata","hi"+sublistdata.get(0).getName());

        recyclerView.setAdapter(customAdapter);  // set the Adapter to RecyclerView



        /*-----------------------------*/


        return view;
    }

}