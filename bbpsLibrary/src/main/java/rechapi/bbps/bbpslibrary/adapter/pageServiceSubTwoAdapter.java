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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import rechapi.bbps.bbpslibrary.R;

public class pageServiceSubTwoAdapter extends RecyclerView.Adapter<pageServiceSubTwoAdapter.MyViewHolder>  {

    ArrayList personNames;
    ArrayList personImages;
    Context context;
    String serviceCategory;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    private  static  final  String shared_pref_name="myPref";

    public pageServiceSubTwoAdapter(Context context, ArrayList personNames, ArrayList personImages) {
        this.context = context;
        this.personNames = personNames;
        this.personImages = personImages;
    }

   /* public serviceCategoryAdapter(Activity activity, ArrayList<serviceCategoryResponse.DataList> list) {
        this.activity = activity;
    }*/

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout_sub_cat, parent, false);
        // set the view's size, margins, paddings and layout parameters
        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
        return vh;

    }
    @SuppressLint("RecyclerView")
    @NonNull

    public void onBindViewHolder(MyViewHolder holder, int position) {

        // set the data in items

        holder.name.setText(personNames.get(position)+"");
        Log.e("helllllllll","hwsgdhsshd"+personNames.toString());

        Glide.with(context).load(personImages.get(position)).into(holder.image);
        Log.e("Image","img"+personImages.get(position));




        // implement setOnClickListener event on item view.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // open another activity on item click
                //   Toast.makeText(context,"position"+position,Toast.LENGTH_SHORT).show();

                Bundle bundle=new Bundle();
                AppCompatActivity activity=(AppCompatActivity) view.getContext();

                // FragmentManager manager=((AppCompatActivity)context).getSupportFragmentManager();
                //  PageOne frg= new PageOne();

                Intent intent=null;

               /* switch (position){
                    case 0:

      *//*sharedPreferences=context.getSharedPreferences(shared_pref_name,MODE_PRIVATE);
      serviceCategory=sharedPreferences.getString("SubCat_data_elct",null);
      editor=sharedPreferences.edit();
      editor.putString("dataSubCat",serviceCategory);
      editor.commit();
      intent=new Intent(activity,bbpsServiceSubCategory.class);
      view.getContext().startService(intent);*//*



                        Toast.makeText(context,"Education fee data is not available",Toast.LENGTH_SHORT).show();


                        break;
                    case 1:
                        sharedPreferences=context.getSharedPreferences(shared_pref_name,MODE_PRIVATE);
                        serviceCategory=sharedPreferences.getString("SubCat_data_elct",null);
                        editor=sharedPreferences.edit();
                        editor.putString("dataSubCat",serviceCategory);
                        editor.commit();
                        intent=new Intent(activity,bbpsServiceSubCategory.class);
                        view.getContext().startService(intent);
                        Toast.makeText(context,"FirstActivity",Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        sharedPreferences=context.getSharedPreferences(shared_pref_name,MODE_PRIVATE);
                        serviceCategory=sharedPreferences.getString("SubCat_data_clubClassic",null); // SubCat_data_clubClassic
                        editor=sharedPreferences.edit();
                        editor.putString("dataSubCat",serviceCategory);
                        editor.commit();
                        intent=new Intent(activity,bbpsServiceSubCategory.class);
                        view.getContext().startService(intent);
                        Toast.makeText(context,"FirstActivity",Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        sharedPreferences=context.getSharedPreferences(shared_pref_name,MODE_PRIVATE);
                        serviceCategory=sharedPreferences.getString("SubCat_data_insurance",null);
                        editor=sharedPreferences.edit();
                        editor.putString("dataSubCat",serviceCategory);
                        editor.commit();
                        intent=new Intent(activity,bbpsServiceSubCategory.class);
                        view.getContext().startService(intent);
                        Toast.makeText(context,"FirstActivity",Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        sharedPreferences=context.getSharedPreferences(shared_pref_name,MODE_PRIVATE);
                        serviceCategory=sharedPreferences.getString("SubCat_data_gas",null);
                        editor=sharedPreferences.edit();
                        editor.putString("dataSubCat",serviceCategory);
                        editor.commit();
                        intent=new Intent(activity,bbpsServiceSubCategory.class);
                        view.getContext().startService(intent);
                        Toast.makeText(context,"FirstActivity",Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
                        sharedPreferences=context.getSharedPreferences(shared_pref_name,MODE_PRIVATE);
                        serviceCategory=sharedPreferences.getString("SubCat_data_dth",null);
                        editor=sharedPreferences.edit();
                        editor.putString("dataSubCat",serviceCategory);
                        editor.commit();
                        intent=new Intent(activity,bbpsServiceSubCategory.class);
                        view.getContext().startService(intent);
                        Toast.makeText(context,"FirstActivity",Toast.LENGTH_SHORT).show();
                        break;
                    case 6:
                        sharedPreferences=context.getSharedPreferences(shared_pref_name,MODE_PRIVATE);
                        serviceCategory=sharedPreferences.getString("ser_Hospital",null);
                        editor=sharedPreferences.edit();
                        editor.putString("dataSubCat",serviceCategory);
                        editor.commit();
                        intent=new Intent(activity,bbpsServiceSubCategory.class);
                        view.getContext().startService(intent);
                        Toast.makeText(context,"FirstActivity",Toast.LENGTH_SHORT).show();
                        break;
                    case 7:
                        sharedPreferences=context.getSharedPreferences(shared_pref_name,MODE_PRIVATE);
                        serviceCategory=sharedPreferences.getString("ser_Subscription",null);
                        editor=sharedPreferences.edit();
                        editor.putString("dataSubCat",serviceCategory);
                        editor.commit();
                        intent=new Intent(activity,bbpsServiceSubCategory.class);
                        view.getContext().startService(intent);
                        Toast.makeText(context,"FirstActivity",Toast.LENGTH_SHORT).show();
                        break;
                    case 8:
                        sharedPreferences=context.getSharedPreferences(shared_pref_name,MODE_PRIVATE);
                        serviceCategory=sharedPreferences.getString("SubCat_data_postpaid",null);
                        editor=sharedPreferences.edit();
                        editor.putString("dataSubCat",serviceCategory);
                        editor.commit();
                        intent=new Intent(activity,bbpsServiceSubCategory.class);
                        view.getContext().startService(intent);
                        Toast.makeText(context,"FirstActivity",Toast.LENGTH_SHORT).show();
                        break;
                    case 9:
                        sharedPreferences=context.getSharedPreferences(shared_pref_name,MODE_PRIVATE);
                        serviceCategory=sharedPreferences.getString("SubCat_data_bsnl",null);
                        editor=sharedPreferences.edit();
                        editor.putString("dataSubCat",serviceCategory);
                        editor.commit();
                        intent=new Intent(activity,bbpsServiceSubCategory.class);
                        view.getContext().startService(intent);
                        Toast.makeText(context,"FirstActivity",Toast.LENGTH_SHORT).show();
                        break;
                    case 10:
                        sharedPreferences=context.getSharedPreferences(shared_pref_name,MODE_PRIVATE);
                        serviceCategory=sharedPreferences.getString("ser_HealthInsurance",null);
                        editor=sharedPreferences.edit();
                        editor.putString("dataSubCat",serviceCategory);
                        editor.commit();
                        intent=new Intent(activity,bbpsServiceSubCategory.class);
                        view.getContext().startService(intent);
                        Toast.makeText(context,"FirstActivity",Toast.LENGTH_SHORT).show();
                        break;

                    default:

                        break;
                }*/

                context.startActivity(intent);



                Log.d("MainActivity", "clicked  "+position);



            }
        });

    }
    @Override
    public int getItemCount() {
        return personNames.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        // init the item view's
        TextView name;
        ImageView image;
        public MyViewHolder(View itemView) {
            super(itemView);
            // get the reference of item view's
            name = (TextView) itemView.findViewById(R.id.name_sub_cat);
            image = (ImageView) itemView.findViewById(R.id.image_sub_cat);

        }
    }
}
