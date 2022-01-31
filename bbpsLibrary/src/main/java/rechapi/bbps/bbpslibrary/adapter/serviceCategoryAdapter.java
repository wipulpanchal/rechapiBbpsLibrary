package rechapi.bbps.bbpslibrary.adapter;

import static android.content.Context.MODE_PRIVATE;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


import rechapi.bbps.bbpslibrary.R;
import rechapi.bbps.bbpslibrary.model.SubCategoriesOne;
import rechapi.bbps.bbpslibrary.sharedPreferenceData.DataProccessor;

public  class serviceCategoryAdapter extends RecyclerView.Adapter<serviceCategoryAdapter.MyViewHolder> implements Filterable {

    ArrayList personNames;
    ArrayList personImages;
    Context context;
    String serviceCategory;
    DataProccessor dataProccessor;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    ArrayList filteredname=new ArrayList<>();
    ArrayList filteredimage=new ArrayList<>();
    private  static  final  String shared_pref_name="myPref";
    List<SubCategoriesOne> sublistdata;

   /* public serviceCategoryAdapter(Context context, ArrayList personNames, ArrayList personImages) {
        this.context = context;
       *//* this.personNames = personNames;
        this.personImages = personImages;*//*
        this.filteredname=personNames;
        this.filteredimage=personImages;
    }*/

    public serviceCategoryAdapter(Context context, List<SubCategoriesOne> sublistdataone) {
        this.context=context;
        this.sublistdata=sublistdataone;
        Log.d("sUBListDatSize","Size"+sublistdata.size());
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
        return vh;

    }
    @SuppressLint("RecyclerView")
    @NonNull

    public void onBindViewHolder(MyViewHolder holder,  int position) {

        // set the data in items

       /* holder.name.setText(personNames.get(position)+"");
        Glide.with(context).load(personImages.get(position)).into(holder.image);*/
        /*holder.name.setText(filteredname.get(position)+"");
        Glide.with(context).load(filteredimage.get(position)).into(holder.image);*/

        holder.name.setText(sublistdata.get(position).getName());
        Glide.with(context).load(sublistdata.get(position).getImage()).into(holder.image);

        Log.d("nameoneeone","ppp"+sublistdata.get(position).getName()+"");
        Log.d("imageoneoneee","ppp"+sublistdata.get(position).getImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle=new Bundle();
                AppCompatActivity activity=(AppCompatActivity) view.getContext();
                dataProccessor=new DataProccessor(view.getContext());

               Intent intent=null;
                switch (position){
                    case 0:
                        sharedPreferences=context.getSharedPreferences(shared_pref_name,MODE_PRIVATE);
                        serviceCategory=sharedPreferences.getString("SubCat_data_water",null);
                        editor=sharedPreferences.edit();
                        editor.putString("dataSubCat",serviceCategory);
                        editor.commit();
                         intent=new Intent(activity,bbpsServiceSubCategory.class);
                         view.getContext().startService(intent);
                        break;
                    case 1:
                        sharedPreferences=context.getSharedPreferences(shared_pref_name,MODE_PRIVATE);
                        serviceCategory=sharedPreferences.getString("SubCat_data_fastag",null);
                        editor=sharedPreferences.edit();
                        editor.putString("dataSubCat",serviceCategory);
                        editor.commit();
                        intent=new Intent(activity,bbpsServiceSubCategory.class);
                        view.getContext().startService(intent);
                        break;
                    case 2:
                        sharedPreferences=context.getSharedPreferences(shared_pref_name,MODE_PRIVATE);
                        serviceCategory=sharedPreferences.getString("ser_MobilePrepaid",null);
                        editor=sharedPreferences.edit();
                        editor.putString("dataSubCat",serviceCategory);
                        editor.commit();
                        intent=new Intent(activity,bbpsServiceSubCategory.class);
                        view.getContext().startService(intent);
                        break;
                        case 3:
                        sharedPreferences=context.getSharedPreferences(shared_pref_name,MODE_PRIVATE);
                        serviceCategory=sharedPreferences.getString("ser_CableTv",null);
                        editor=sharedPreferences.edit();
                        editor.putString("dataSubCat",serviceCategory);
                        editor.commit();
                        intent=new Intent(activity,bbpsServiceSubCategory.class);
                        view.getContext().startService(intent);
                        break;
                        case 4:
                        sharedPreferences=context.getSharedPreferences(shared_pref_name,MODE_PRIVATE);
                        serviceCategory=sharedPreferences.getString("ser_LifeInsurance",null);
                        editor=sharedPreferences.edit();
                        editor.putString("dataSubCat",serviceCategory);
                        editor.commit();
                        intent=new Intent(activity,bbpsServiceSubCategory.class);
                        view.getContext().startService(intent);
                        break;
                        case 5:
                        sharedPreferences=context.getSharedPreferences(shared_pref_name,MODE_PRIVATE);
                        serviceCategory=sharedPreferences.getString("ser_MuncipleServices",null);
                        editor=sharedPreferences.edit();
                        editor.putString("dataSubCat",serviceCategory);
                        editor.commit();
                        intent=new Intent(activity,bbpsServiceSubCategory.class);
                        view.getContext().startService(intent);
                        break;
                        case 6:
                        sharedPreferences=context.getSharedPreferences(shared_pref_name,MODE_PRIVATE);
                        serviceCategory=sharedPreferences.getString("SubCat_ser_HousingSocity",null);
                        editor=sharedPreferences.edit();
                        editor.putString("dataSubCat",serviceCategory);
                        editor.commit();
                        intent=new Intent(activity,bbpsServiceSubCategory.class);
                        view.getContext().startService(intent);
                        break;
                        case 7:
                        sharedPreferences=context.getSharedPreferences(shared_pref_name,MODE_PRIVATE);
                        serviceCategory=sharedPreferences.getString("ser_MunicipleTaxex",null);
                        editor=sharedPreferences.edit();
                        editor.putString("dataSubCat",serviceCategory);
                        editor.commit();
                        intent=new Intent(activity,bbpsServiceSubCategory.class);
                        view.getContext().startService(intent);
                        break;
                        case 8:
                        sharedPreferences=context.getSharedPreferences(shared_pref_name,MODE_PRIVATE);
                        serviceCategory=sharedPreferences.getString("ser_LoanRepayment",null);
                        editor=sharedPreferences.edit();
                        editor.putString("dataSubCat",serviceCategory);
                        editor.commit();
                        intent=new Intent(activity,bbpsServiceSubCategory.class);
                        view.getContext().startService(intent);
                        break;
                        case 9:
                        sharedPreferences=context.getSharedPreferences(shared_pref_name,MODE_PRIVATE);
                        serviceCategory=sharedPreferences.getString("ser_LpgGas",null);
                        editor=sharedPreferences.edit();
                        editor.putString("dataSubCat",serviceCategory);
                        editor.commit();
                        intent=new Intent(activity,bbpsServiceSubCategory.class);
                        view.getContext().startService(intent);
                        break;
                        case 10:
                        sharedPreferences=context.getSharedPreferences(shared_pref_name,MODE_PRIVATE);
                        serviceCategory=sharedPreferences.getString("ser_CreditCard",null);
                        editor=sharedPreferences.edit();
                        editor.putString("dataSubCat",serviceCategory);
                        editor.commit();
                        intent=new Intent(activity,bbpsServiceSubCategory.class);
                        view.getContext().startService(intent);
                        break;
                        case 11:
                        sharedPreferences=context.getSharedPreferences(shared_pref_name,MODE_PRIVATE);
                        serviceCategory=sharedPreferences.getString("SubCat_data_broadBand",null);
                        editor=sharedPreferences.edit();
                        editor.putString("dataSubCat",serviceCategory);
                        editor.commit();
                        intent=new Intent(activity,bbpsServiceSubCategory.class);
                        view.getContext().startService(intent);
                        break;

                    default:

                        break;
                }

                context.startActivity(intent);



                Log.d("MainActivity", "clicked  "+position);



            }
        });

    }
    @Override
    public int getItemCount() {
        return sublistdata.size();
    }

    @Override
    public Filter getFilter() {
        return null;
    }











    public class MyViewHolder extends RecyclerView.ViewHolder {
        // init the item view's
        TextView name;
        ImageView image;
        public MyViewHolder(View itemView) {
            super(itemView);
            // get the reference of item view's
            name = (TextView) itemView.findViewById(R.id.name);
            image = (ImageView) itemView.findViewById(R.id.imagesub);

        }
    }
}
