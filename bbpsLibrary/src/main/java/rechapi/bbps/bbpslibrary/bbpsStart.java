package rechapi.bbps.bbpslibrary;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rechapi.bbps.bbpslibrary.adapter.bbpsServiceSubCategory;
import rechapi.bbps.bbpslibrary.response.serviceCategoryResponse;

public class bbpsStart extends AppCompatActivity {

    private Context context;
    private Activity activity;
    JSONObject objServiceCategory,objSubCategory;
    Map<String,String> map_electricity,map_insurance,mapGas,
            mobile_Postpaid,ser_bsnl,ser_water,
            ser_broadBandP,ser_dth,ser_club_assc,ser_fastag
            ,ser_CableTv,ser_HealthInsurance,ser_LifeInsurance,ser_Subscription
            ,ser_LoanRepayment,ser_LpgGas,ser_Hospital,ser_CreditCard,
            ser_MuncipleServices,ser_MobilePrepaid,ser_MunicipleTaxex,ser_HousingSocity,ser_Education;
    SharedPreferences sharedPreferences;
    private  static  final  String shared_pref_name="myPref";
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activity = bbpsStart.this;
        sharedPreferences=getSharedPreferences(shared_pref_name,MODE_PRIVATE);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
        ArrayList<String> aList = new ArrayList<String>();
        Map<String,String> map1 = new HashMap<>();



        map1.put("userId","45487");

        Map<String,String> map2 = new HashMap<>();
        map2.put("token","K565SoRLUEFAOX9VUdraogXz7");
        map2.put("outletMobile","9006762209");
        map2.put("api","sandbox");
        map2.put("userData","helloTest");


        Map<String, String> mapFinal = new HashMap<>();

       // List<String> subcat_name = new ArrayList<String>();
        // JSONObject obj1=Util.mapToJson(map1);

        JSONObject obj2=Util.mapToJson(map2);
        String encrypted =Util.encryptRequest(obj2.toString());


        mapFinal.put("data",encrypted);
        mapFinal.put("userId","45487");
        JSONObject obj=Util.mapToJson(mapFinal);

        Log.d("MainActivity:-obj","Data is "+obj);

        WebConnection wb = new WebConnection(context,"https://bbps.rechapi.com/serviceCategory.php");
        try{

            JSONObject response=wb.sendPost(obj.toString());

            String encryptedResponse=response.getString("response");
            String descyptedResponse=Util.decryptResponse(encryptedResponse);

            Log.d("MainActivityData", "response_descdata  "+descyptedResponse);
            serviceCategoryResponse responseModal = new Gson().fromJson(descyptedResponse, serviceCategoryResponse.class);

            map_electricity = new HashMap<>();
            map_insurance = new HashMap<>();
            mapGas = new HashMap<>();
            mobile_Postpaid = new HashMap<>();
            ser_bsnl = new HashMap<>();
            ser_water = new HashMap<>();
            ser_broadBandP = new HashMap<>();
            ser_dth = new HashMap<>();
            ser_club_assc = new HashMap<>();
            ser_fastag = new HashMap<>();
            /*-----------------*/

            ser_CableTv = new HashMap<>();
            ser_HealthInsurance = new HashMap<>();
            ser_LifeInsurance = new HashMap<>();
            ser_Subscription = new HashMap<>();
            ser_LoanRepayment = new HashMap<>();
            ser_LpgGas = new HashMap<>();
            ser_Hospital = new HashMap<>();
            ser_CreditCard = new HashMap<>();
            ser_MuncipleServices = new HashMap<>();
            ser_MobilePrepaid = new HashMap<>();
            ser_MunicipleTaxex = new HashMap<>();
            ser_HousingSocity = new HashMap<>();

/*-------------------------*/
            try {

                if(responseModal.getStatus().equals("SUCCESS")){
                    try{
                        Map<String, String> mapServiceList = new HashMap<>();

                        for(int i=0;i<responseModal.getServiceList().size();i++){

                            Log.d("total_data","dataSize:-"+responseModal.getServiceList().size());
                            Log.d("MainActivity", "dataList  "+responseModal.getServiceList().get(i).getCategoryCode()+" "+responseModal.getServiceList().get(i).getName());

                           switch (responseModal.getServiceList().get(i).getCategoryCode()){
                               case "1":
                                   Log.d("hello:-","hhhhh:"+responseModal.getServiceList().get(i).getType()+" "+responseModal.getServiceList().get(i).getIconUrl());
                                    map_electricity.put(responseModal.getServiceList().get(i).getName(),responseModal.getServiceList().get(i).getIconUrl());
                                    objSubCategory=Util.mapToJson(map_electricity);
                                    editor=sharedPreferences.edit();
                                    editor.putString("SubCat_data_elct",objSubCategory.toString());
                                    editor.commit();
                                    Log.d("mapValue:-","mapData:-"+objSubCategory.toString());
                                    break;
                               case "3":
                                   map_insurance.put(responseModal.getServiceList().get(i).getType(),responseModal.getServiceList().get(i).getIconUrl());
                                   objSubCategory=Util.mapToJson(map_insurance);
                                   editor=sharedPreferences.edit();
                                   editor.putString("SubCat_data_insurance",objSubCategory.toString());
                                   editor.commit();
                                   Log.d("map4","hhhhh:"+map_insurance);

                                   break;
                               case "14":
                                   Log.d("hello:-","hhhhh:"+responseModal.getServiceList().get(i).getType()+" "+responseModal.getServiceList().get(i).getIconUrl());
                                   mapGas.put(responseModal.getServiceList().get(i).getType(),responseModal.getServiceList().get(i).getIconUrl());
                                   objSubCategory=Util.mapToJson(mapGas);
                                   editor=sharedPreferences.edit();
                                   editor.putString("SubCat_data_gas",objSubCategory.toString());
                                   editor.commit();
                                   Log.d("mapGas","hhhhh:"+mapGas);
                                   break;
                               case "17":
                                   Log.d("hello:-","hhhhh:"+responseModal.getServiceList().get(i).getType()+" "+responseModal.getServiceList().get(i).getIconUrl());
                                   mobile_Postpaid.put(responseModal.getServiceList().get(i).getType(),responseModal.getServiceList().get(i).getIconUrl());
                                   objSubCategory=Util.mapToJson(mobile_Postpaid);
                                   editor=sharedPreferences.edit();
                                   editor.putString("SubCat_data_postpaid",objSubCategory.toString());
                                   editor.commit();

                                   Log.d("mapWater","water:-"+mobile_Postpaid);
                                   break;
                               case "18":
                                   Log.d("hello:-","hhhhh:"+responseModal.getServiceList().get(i).getType()+" "+responseModal.getServiceList().get(i).getIconUrl());
                                   ser_bsnl.put(responseModal.getServiceList().get(i).getName(),responseModal.getServiceList().get(i).getIconUrl());
                                   objSubCategory=Util.mapToJson(ser_bsnl);
                                   editor=sharedPreferences.edit();
                                   editor.putString("SubCat_data_bsnl",objSubCategory.toString());
                                   editor.commit();
                                   Log.d("mapValue:-","mapData:-"+objSubCategory.toString());
                                   Log.d("ser_bsnl","ser_bsnl:-"+ser_bsnl);

                                   break;
                               case "19":
                                   Log.d("hello:-","hhhhh:"+responseModal.getServiceList().get(i).getType()+" "+responseModal.getServiceList().get(i).getIconUrl());
                                   ser_water.put(responseModal.getServiceList().get(i).getName(),responseModal.getServiceList().get(i).getIconUrl());
                                   objSubCategory=Util.mapToJson(ser_water);
                                   editor=sharedPreferences.edit();
                                   editor.putString("SubCat_data_water",objSubCategory.toString());
                                   editor.commit();
                                   Log.d("ser_water","ser_water:-"+ser_water);
                                   break;

                               case "21":
                                   Log.d("hello:-","hhhhh:"+responseModal.getServiceList().get(i).getType()+" "+responseModal.getServiceList().get(i).getIconUrl());
                                   ser_broadBandP.put(responseModal.getServiceList().get(i).getType(),responseModal.getServiceList().get(i).getIconUrl());
                                   objSubCategory=Util.mapToJson(ser_broadBandP);
                                   editor=sharedPreferences.edit();
                                   editor.putString("SubCat_data_broadBand",objSubCategory.toString());
                                   editor.commit();
                                   Log.d("ser_3","ser_broadBandP:-"+ser_broadBandP); break;
                               case "20":
                                   Log.d("hello:-","hhhhh:"+responseModal.getServiceList().get(i).getType()+" "+responseModal.getServiceList().get(i).getIconUrl());
                                   ser_dth.put(responseModal.getServiceList().get(i).getType(),responseModal.getServiceList().get(i).getIconUrl());
                                   objSubCategory=Util.mapToJson(ser_dth);
                                   editor=sharedPreferences.edit();
                                   editor.putString("SubCat_data_dth",objSubCategory.toString());
                                   editor.commit();

                                   Log.d("ser_dth","ser_dth:-"+ser_dth); break;
                               case "22":
                                   Log.d("hello:-","hhhhh:"+responseModal.getServiceList().get(i).getType()+" "+responseModal.getServiceList().get(i).getIconUrl());
                                   ser_club_assc.put(responseModal.getServiceList().get(i).getType(),responseModal.getServiceList().get(i).getIconUrl());
                                   objSubCategory=Util.mapToJson(ser_club_assc);
                                   editor=sharedPreferences.edit();
                                   editor.putString("SubCat_data_clubClassic",objSubCategory.toString());
                                   editor.commit();
                                   Log.d("ser_club_assc","ser_club_assc:-"+ser_club_assc); break;
                               case "30":
                                   Log.d("hello:-","hhhhh:"+responseModal.getServiceList().get(i).getType()+" "+responseModal.getServiceList().get(i).getIconUrl());
                                   ser_fastag.put(responseModal.getServiceList().get(i).getName(),responseModal.getServiceList().get(i).getIconUrl());
                                   objSubCategory=Util.mapToJson(ser_fastag);
                                   editor=sharedPreferences.edit();
                                   editor.putString("SubCat_data_fastag",objSubCategory.toString());
                                   editor.commit();
                                   Log.d("ser_fastag","ser_fastag:-"+ser_fastag);

                                   break;
                               case "34":
                                   Log.d("hello:-","hhhhh:"+responseModal.getServiceList().get(i).getType()+" "+responseModal.getServiceList().get(i).getIconUrl());
                                   ser_HousingSocity.put(responseModal.getServiceList().get(i).getName(),responseModal.getServiceList().get(i).getIconUrl());
                                   objSubCategory=Util.mapToJson(ser_HousingSocity);
                                   editor=sharedPreferences.edit();
                                   editor.putString("SubCat_ser_HousingSocity",objSubCategory.toString());
                                   editor.commit();
                                   Log.d("ser_HousingSocity","ser_HousingSocity:-"+ser_HousingSocity);

                                   break;
                               case "35":
                                   Log.d("hello:-","hhhhh:"+responseModal.getServiceList().get(i).getType()+" "+responseModal.getServiceList().get(i).getIconUrl());
                                   ser_MunicipleTaxex.put(responseModal.getServiceList().get(i).getName(),responseModal.getServiceList().get(i).getIconUrl());
                                   objSubCategory=Util.mapToJson(ser_MunicipleTaxex);
                                   editor=sharedPreferences.edit();
                                   editor.putString("ser_MunicipleTaxex",objSubCategory.toString());
                                   editor.commit();
                                   Log.d("ser_MunicipleTaxex","ser_MunicipleTaxex:-"+ser_MunicipleTaxex);

                                   break;
                                   case "24":
                                   Log.d("hello:-","hhhhh:"+responseModal.getServiceList().get(i).getType()+" "+responseModal.getServiceList().get(i).getIconUrl());
                                   ser_MobilePrepaid.put(responseModal.getServiceList().get(i).getName(),responseModal.getServiceList().get(i).getIconUrl());
                                   objSubCategory=Util.mapToJson(ser_MobilePrepaid);
                                   editor=sharedPreferences.edit();
                                   editor.putString("ser_MobilePrepaid",objSubCategory.toString());
                                   editor.commit();
                                   Log.d("ser_MobilePrepaid","ser_MobilePrepaid:-"+ser_MobilePrepaid);

                                   break;
                                   case "36":
                                   Log.d("hello:-","hhhhh:"+responseModal.getServiceList().get(i).getType()+" "+responseModal.getServiceList().get(i).getIconUrl());
                                   ser_MuncipleServices.put(responseModal.getServiceList().get(i).getName(),responseModal.getServiceList().get(i).getIconUrl());
                                   objSubCategory=Util.mapToJson(ser_MuncipleServices);
                                   editor=sharedPreferences.edit();
                                   editor.putString("ser_MuncipleServices",objSubCategory.toString());
                                   editor.commit();
                                   Log.d("ser_MuncipleServices","water:-"+ser_MuncipleServices);

                                   break;
                                   case "26":
                                   Log.d("hello:-","hhhhh:"+responseModal.getServiceList().get(i).getType()+" "+responseModal.getServiceList().get(i).getIconUrl());
                                   ser_CreditCard.put(responseModal.getServiceList().get(i).getName(),responseModal.getServiceList().get(i).getIconUrl());
                                   objSubCategory=Util.mapToJson(ser_CreditCard);
                                   editor=sharedPreferences.edit();
                                   editor.putString("ser_CreditCard",objSubCategory.toString());
                                   editor.commit();
                                   Log.d("ser_CreditCard","ser_CreditCard:-"+ser_CreditCard);

                                   break;
                                   case "37":
                                   Log.d("hello:-","hhhhh:"+responseModal.getServiceList().get(i).getType()+" "+responseModal.getServiceList().get(i).getIconUrl());
                                   ser_Hospital.put(responseModal.getServiceList().get(i).getName(),responseModal.getServiceList().get(i).getIconUrl());
                                   objSubCategory=Util.mapToJson(ser_Hospital);
                                   editor=sharedPreferences.edit();
                                   editor.putString("ser_Hospital",objSubCategory.toString());
                                   editor.commit();
                                   Log.d("ser_Hospital","ser_Hospital:-"+ser_Hospital);

                                   break;
                                   case "27":
                                   Log.d("hello:-","hhhhh:"+responseModal.getServiceList().get(i).getType()+" "+responseModal.getServiceList().get(i).getIconUrl());
                                   ser_LpgGas.put(responseModal.getServiceList().get(i).getName(),responseModal.getServiceList().get(i).getIconUrl());
                                   objSubCategory=Util.mapToJson(ser_LpgGas);
                                   editor=sharedPreferences.edit();
                                   editor.putString("ser_LpgGas",objSubCategory.toString());
                                   editor.commit();
                                   Log.d("ser_LpgGas","ser_LpgGas:-"+ser_LpgGas);

                                   break;
                                   case "28":
                                   Log.d("hello:-","hhhhh:"+responseModal.getServiceList().get(i).getType()+" "+responseModal.getServiceList().get(i).getIconUrl());
                                   ser_LoanRepayment.put(responseModal.getServiceList().get(i).getName(),responseModal.getServiceList().get(i).getIconUrl());
                                   objSubCategory=Util.mapToJson(ser_LoanRepayment);
                                   editor=sharedPreferences.edit();
                                   editor.putString("ser_LoanRepayment",objSubCategory.toString());
                                   editor.commit();
                                   Log.d("ser_LoanRepayment","ser_LoanRepayment:-"+ser_LoanRepayment);

                                   break;
                                   case "39":
                                   Log.d("hello:-","hhhhh:"+responseModal.getServiceList().get(i).getType()+" "+responseModal.getServiceList().get(i).getIconUrl());
                                   ser_Subscription.put(responseModal.getServiceList().get(i).getName(),responseModal.getServiceList().get(i).getIconUrl());
                                   objSubCategory=Util.mapToJson(ser_Subscription);
                                   editor=sharedPreferences.edit();
                                   editor.putString("ser_Subscription",objSubCategory.toString());
                                   editor.commit();
                                   Log.d("ser_Subscription","water:-"+ser_Subscription);

                                   break;
                                   case "29":
                                   Log.d("hello:-","hhhhh:"+responseModal.getServiceList().get(i).getType()+" "+responseModal.getServiceList().get(i).getIconUrl());
                                   ser_LifeInsurance.put(responseModal.getServiceList().get(i).getName(),responseModal.getServiceList().get(i).getIconUrl());
                                   objSubCategory=Util.mapToJson(ser_LifeInsurance);
                                   editor=sharedPreferences.edit();
                                   editor.putString("ser_LifeInsurance",objSubCategory.toString());
                                   editor.commit();
                                   Log.d("ser_LifeInsurance","ser_LifeInsurance:-"+ser_LifeInsurance);

                                   break;
                                   case "31":
                                   Log.d("hello:-","hhhhh:"+responseModal.getServiceList().get(i).getType()+" "+responseModal.getServiceList().get(i).getIconUrl());
                                   ser_HealthInsurance.put(responseModal.getServiceList().get(i).getName(),responseModal.getServiceList().get(i).getIconUrl());
                                   objSubCategory=Util.mapToJson(ser_HealthInsurance);
                                   editor=sharedPreferences.edit();
                                   editor.putString("ser_HealthInsurance",objSubCategory.toString());
                                   editor.commit();
                                   Log.d("ser_HealthInsurance","ser_HealthInsurance:-"+ser_HealthInsurance);

                                   break;

                                   case "32":
                                   Log.d("hello:-","hhhhh:"+responseModal.getServiceList().get(i).getType()+" "+responseModal.getServiceList().get(i).getIconUrl());
                                   ser_CableTv.put(responseModal.getServiceList().get(i).getName(),responseModal.getServiceList().get(i).getIconUrl());
                                   objSubCategory=Util.mapToJson(ser_CableTv);
                                   editor=sharedPreferences.edit();
                                   editor.putString("ser_CableTv",objSubCategory.toString());
                                   editor.commit();
                                   Log.d("ser_CableTv","ser_CableTv:-"+ser_CableTv);

                                   break;

                              /* case "":
                                   Log.d("hello:-","hhhhh:"+responseModal.getServiceList().get(i).getType()+" "+responseModal.getServiceList().get(i).getIconUrl());
                                   ser_Education.put(responseModal.getServiceList().get(i).getName(),responseModal.getServiceList().get(i).getIconUrl());
                                   objSubCategory=Util.mapToJson(ser_Education);
                                   editor=sharedPreferences.edit();
                                   editor.putString("ser_Education",objSubCategory.toString());
                                   editor.commit();
                                   Log.d("ser_Education","ser_Education:-"+ser_Education);
                                   break;*/

                               default:

                                   break;
                           }

                            mapServiceList.put(responseModal.getServiceList().get(i).getType(),responseModal.getServiceList().get(i).getIconUrl());
                           // mapServiceList.put(responseModal.getServiceList().get(i).getCategoryCode(),responseModal.getServiceList().get(i).getType());
                            Log.d("hehehehehe:-","jhdhdhhd:-"+responseModal.getServiceList().get(i).getCategoryCode());
                            Log.e("MapData","MappingData"+mapServiceList);
                            Log.d("MainActivityHelloBuddy", "dataList  "+responseModal.getServiceList().get(i).getCategoryCode()+" "+responseModal.getServiceList().get(i).getName());
                        }

                         objServiceCategory=Util.mapToJson(mapServiceList);
                         Log.d("MainActivityCategory:-", "ServiceCategory "+objServiceCategory.toString());
                         Intent intent = new Intent(bbpsStart.this, bbpsServiceCategory.class);
                         intent.putExtra("serviceCategory", objServiceCategory.toString());
                         startActivity(intent);

                    }
                    catch (Exception e){
                        Log.d("MainActivity", "Activity Error  "+e.toString());
                    }

                }

            } catch (Exception t) {
                Log.e("MainActivity", "Could not parse malformed JSON:");
            }

            //Log.d("MainActivity"," response "+descyptedResponse);
        }
        catch (Exception e){
            Log.d("MainActivity"," response error "+e.toString());
        }

    }

    private void setAdapter(ArrayList<serviceCategoryResponse.DataList> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        // mBinding.recyclerView.setAdapter(new serviceCategoryAdapter(bbpsStart.this, list));
    }

}
