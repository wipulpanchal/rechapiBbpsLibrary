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

import rechapi.bbps.bbpslibrary.adapter.serviceCategory2ndAdapter;
import rechapi.bbps.bbpslibrary.adapter.serviceCategoryAdapter;
import rechapi.bbps.bbpslibrary.model.SubCategoriesOne;

public class Page2 extends Fragment {

    ArrayList personNames ;
    ArrayList personImageshello ,personImagesone,personImagetwo,personnameone,personnametwo;
    Iterator itername;
    RecyclerView recyclerView;
    List<SubCategoriesOne> sublistdata;
    Context context;


    public Page2(Context applicationContext, List<SubCategoriesOne> sublistdataone) {

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
        View view=inflater.inflate(R.layout.fragment_page2,container,false);

        String serviceCategory = getActivity().getIntent().getStringExtra("serviceCategory");
        personImageshello = new ArrayList<>(Arrays.asList());
        personImagesone = new ArrayList<>(Arrays.asList());
        personImagetwo = new ArrayList<>(Arrays.asList());
        personNames = new ArrayList<>(Arrays.asList());
        personnameone = new ArrayList<>(Arrays.asList());
        personnametwo = new ArrayList<>(Arrays.asList());



        try {

            Log.d("SizeofData:-","hello"+serviceCategory.length());
            JSONObject issueObj = new JSONObject(serviceCategory);
            Log.e("totaldata:-","helloo:-"+issueObj.length());

            itername = issueObj.keys();
            while(itername.hasNext()) {
                String key = (String) itername.next(); //
                try {
                    Object value = issueObj.get(key);
                    personImageshello.add(value); // image
                } catch (JSONException e) {
                    // Something went wrong!
                }
                personNames.add(key); // name
                if (issueObj.get(key) instanceof JSONObject) {
                    // do something with jsonObject here
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
            Log.e("exceptionErrro:-","hello"+e);
        }


        for(int i=0;i<personImageshello.size();i++){
            if(i<=11){
                personImagesone.add(personImageshello.get(i));
                personnameone.add(personNames.get(i));
            }else {
                personImagetwo.add(personImageshello.get(i));
                personnametwo.add(personNames.get(i));
            }
        }




        Log.d("imageoneArraySize:-","imageOne:-"+personImagesone.size());
        Log.d("personNameone:-","personNameone"+personnameone.size());


        Log.d("imagetwoArraySize:-","imahgeTwo:-"+personImagetwo.size());
        Log.d("personNameTwo:-","personNameTwo"+personnametwo.size());

        // get the reference of RecyclerView
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_page2);
        // set a GridLayoutManager with default vertical orientation and 2 number of columns
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),4);
        recyclerView.setLayoutManager(gridLayoutManager); // set LayoutManager to RecyclerView

        //  call the constructor of CustomAdapter to send the reference and data to Adapter
        //   serviceCategoryAdapter customAdapter = new serviceCategoryAdapter(getContext(), personNames,personImageshello);

      //  serviceCategory2ndAdapter customAdapter = new serviceCategory2ndAdapter(getContext(), personnametwo,personImagetwo);
        serviceCategory2ndAdapter customAdapter = new serviceCategory2ndAdapter(getContext(),sublistdata);

        recyclerView.setAdapter(customAdapter); // set the Adapter to RecyclerView

        /*-----------------------------*/


        return view;
    }
}