package rechapi.bbps.bbpslibrary.fragment;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
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

import rechapi.bbps.bbpslibrary.R;
import rechapi.bbps.bbpslibrary.adapter.serviceSubCategory;

public class pageSubCategoryfourteen  extends Fragment {

    //  ArrayList personImageshello,personNames,personImagesone,personImagetwo,personnameone,personnametwo;

    ArrayList personImageshello,personNames,personImagesone,personImagetwo,personnameone,personnametwo
            ,pnthree,pgthree,pnfour,pgfour,pnfive,pgfive,pnsix,pgsix,pnseven,pgseven,pneight,pgeight
            ,pnnine,pgnine,pnten,pgten,pneleven,pgeleven,pntwelve,pgtwelve,pnthirteen,pgthirteen,pnfourteen,pgfourteen
            ,pnfifteen,pgfifteen,pnsixteen,pgsixteen,pnseventy,pgseventeen,pneighteen,pgeighteen,pnninteen,pgninteen;



    Iterator itername;
    RecyclerView recyclerView;
    String serviceCategory;
    SharedPreferences sharedPreferences;
    private  static  final  String shared_pref_name="myPref";

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.page_sub_cate_one,container,false);


        /*-------------------------*/
        serviceCategory = getActivity().getIntent().getStringExtra("serviceCategory");
        personImageshello = new ArrayList<>(Arrays.asList());
        personImagesone = new ArrayList<>(Arrays.asList());
        personImagetwo = new ArrayList<>(Arrays.asList());
        personNames = new ArrayList<>(Arrays.asList());
        personnameone = new ArrayList<>(Arrays.asList());
        personnametwo = new ArrayList<>(Arrays.asList());

        /*--------------------*/


        pnthree = new ArrayList<>(Arrays.asList());
        pnfour = new ArrayList<>(Arrays.asList());
        pnfive = new ArrayList<>(Arrays.asList());
        pnsix = new ArrayList<>(Arrays.asList());
        pnseven = new ArrayList<>(Arrays.asList());
        pneight = new ArrayList<>(Arrays.asList());
        pnnine = new ArrayList<>(Arrays.asList());
        pnten = new ArrayList<>(Arrays.asList());
        pneleven = new ArrayList<>(Arrays.asList());
        pntwelve = new ArrayList<>(Arrays.asList());
        pnthirteen = new ArrayList<>(Arrays.asList());
        pnfourteen = new ArrayList<>(Arrays.asList());
        pnfifteen = new ArrayList<>(Arrays.asList());
        pnsixteen = new ArrayList<>(Arrays.asList());
        pnseventy = new ArrayList<>(Arrays.asList());
        pneighteen = new ArrayList<>(Arrays.asList());
        pnninteen = new ArrayList<>(Arrays.asList());


        pgthree = new ArrayList<>(Arrays.asList());
        pgfour = new ArrayList<>(Arrays.asList());
        pgfive = new ArrayList<>(Arrays.asList());
        pgsix = new ArrayList<>(Arrays.asList());
        pgseven = new ArrayList<>(Arrays.asList());
        pgeight = new ArrayList<>(Arrays.asList());
        pgnine = new ArrayList<>(Arrays.asList());
        pgten = new ArrayList<>(Arrays.asList());
        pgeleven = new ArrayList<>(Arrays.asList());
        pgtwelve = new ArrayList<>(Arrays.asList());
        pgthirteen = new ArrayList<>(Arrays.asList());
        pgfourteen = new ArrayList<>(Arrays.asList());
        pgfifteen = new ArrayList<>(Arrays.asList());
        pgsixteen = new ArrayList<>(Arrays.asList());
        pgseventeen = new ArrayList<>(Arrays.asList());
        pgeighteen = new ArrayList<>(Arrays.asList());
        pgninteen = new ArrayList<>(Arrays.asList());


        /*------------------*/


        sharedPreferences=getActivity().getSharedPreferences(shared_pref_name,MODE_PRIVATE);
        if(sharedPreferences!=null){
            serviceCategory=sharedPreferences.getString("dataSubCat",null);
        }else {
            Log.d("dataIsNull:-","nullSharedPreference"+sharedPreferences);
        }

        Log.d("helloBuddyyyyySubCategory:-","hiiiii"+serviceCategory);
        Log.d("helloBuddySubCAtttt:-","hiiiii"+serviceCategory.length());


        try {

            JSONObject issueObj = new JSONObject(serviceCategory);
            Log.e("totaldata:-","helloo:-"+issueObj.length());
            // dataProccessor.setInt_sub_cat_size(issueObj.length());
            itername = issueObj.keys();

            while(itername.hasNext()) {
                String key = (String) itername.next();
                try {
                    Object value = issueObj.get(key);
                    personImageshello.add(value);
                } catch (JSONException e) {
                    // Something went wrong!
                }
                personNames.add(key);

                if (issueObj.get(key) instanceof JSONObject) {
                    // do something with jsonObject here
                }
            }



        } catch (JSONException e) {
            e.printStackTrace();
            Log.e("exceptionErrro:-","hello"+e);
        }
        /*---------------------------------*/
        for(int i=0;i<personImageshello.size();i++){
            if(i<=8){
                personImagesone.add(personImageshello.get(i));
                personnameone.add(personNames.get(i));
            }else if(i<=16){
                personImagetwo.add(personImageshello.get(i));
                personnametwo.add(personNames.get(i));
            }else if(i<=24){
                pnthree.add(personNames.get(i));
                pgthree.add(personImageshello.get(i));
            }else if(i<=32){
                pnfour.add(personNames.get(i));
                pgfour.add(personImageshello.get(i));
            }else if(i<=40){
                pnfive.add(personNames.get(i));
                pgfive.add(personImageshello.get(i));
            }else if(i<=48){
                pnsix.add(personNames.get(i));
                pgsix.add(personImageshello.get(i));
            }else if(i<=56){
                pnseven.add(personNames.get(i));
                pgseven.add(personImageshello.get(i));
            }else if(i<=64){
                pneight.add(personNames.get(i));
                pgeight.add(personImageshello.get(i));
            }else if(i<=72){
                pnnine.add(personNames.get(i));
                pgnine.add(personImageshello.get(i));
            }else if(i<=80){
                pnten.add(personNames.get(i));
                pgten.add(personImageshello.get(i));
            }else if(i<=88){
                pneleven.add(personNames.get(i));
                pgeleven.add(personImageshello.get(i));
            }else if(i<=96){
                pntwelve.add(personNames.get(i));
                pgtwelve.add(personImageshello.get(i));
            }else if(i<=102){
                pnthirteen.add(personNames.get(i));
                pgthirteen.add(personImageshello.get(i));
            }else if(i<=110){
                pnfourteen.add(personNames.get(i));
                pgfourteen.add(personImageshello.get(i));
            }else if(i<=118){
                pnfifteen.add(personNames.get(i));
                pgfifteen.add(personImageshello.get(i));
            }else if(i<=126){
                pnsixteen.add(personNames.get(i));
                pgsixteen.add(personImageshello.get(i));
            }else if(i<=132){
                pnseventy.add(personNames.get(i));
                pgseventeen.add(personImageshello.get(i));
            }else if(i<=140){
                pneighteen.add(personNames.get(i));
                pgeighteen.add(personImageshello.get(i));
            }else if(i<=148){
                pnninteen.add(personNames.get(i));
                pgninteen.add(personImageshello.get(i));
            }
        }


        /*------------------------------------*/
        Log.d("imageoneArraySize:-","imageOne:-"+personImagesone.size());
        Log.d("personNameone:-","personNameone"+personnameone.size());


        Log.d("imagetwoArraySize:-","imahgeTwo:-"+personImagetwo.size());
        Log.d("personNameTwo:-","personNameTwo"+personnametwo.size());

        // get the reference of RecyclerView
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_sub_cat_ityem);
        // set a GridLayoutManager with default vertical orientation and 2 number of columns
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),3);
        recyclerView.setLayoutManager(gridLayoutManager); // set LayoutManager to RecyclerView

        //  call the constructor of CustomAdapter to send the reference and data to Adapter
        //   serviceCategoryAdapter customAdapter = new serviceCategoryAdapter(getContext(), personNames,personImageshello);

       /* pageServiceSubTwoAdapter customAdapter = new pageServiceSubTwoAdapter(getContext(), personnametwo,personImagetwo);

        recyclerView.setAdapter(customAdapter); // set the Adapter to RecyclerView
*/

        serviceSubCategory customAdapter = new serviceSubCategory(getContext(), pnfourteen,pgfourteen);
        recyclerView.setAdapter(customAdapter);


        /*-----------------------------*/


        return view;
    }
}

