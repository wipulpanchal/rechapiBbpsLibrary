package rechapi.bbps.bbpslibrary.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import rechapi.bbps.bbpslibrary.R;
import rechapi.bbps.bbpslibrary.fragment.PageOne;
import rechapi.bbps.bbpslibrary.viewPager.ViewPagerAdapter;

public  class serviceSubCategory extends RecyclerView.Adapter<serviceSubCategory.MyViewHolder>  {

    ArrayList personNames;
    ArrayList personImages;
    Context context;

    public serviceSubCategory(Context context, ArrayList personNames, ArrayList personImages) {
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

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_sub_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
        return vh;

    }
    @SuppressLint("RecyclerView")
    @NonNull

    public void onBindViewHolder(MyViewHolder holder,  int position) {

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

                holder.name.setText(personNames.get(position)+"");
                Log.e("heone","name_one"+personNames.get(position));
                Glide.with(context).load(personImages.get(position)).into(holder.image);
                Log.e("Imageone","img_one"+personImages.get(position));
                Bundle bundle=new Bundle();
                AppCompatActivity activity=(AppCompatActivity) view.getContext();
                 FragmentManager manager=((AppCompatActivity)context).getSupportFragmentManager();
                 PageOne frg= new PageOne(personNames.get(position),personImages.get(position));
               // Intent intent=null;
                Toast.makeText(context,"HelloBuddy"+position,Toast.LENGTH_SHORT).show();
              //  activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout_one,frg).addToBackStack(null).commit();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.viewPager_frame_layout,frg).addToBackStack(null).commit();



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
            name = (TextView) itemView.findViewById(R.id.sub_name);
            image = (ImageView) itemView.findViewById(R.id.sub_image);


        }
    }
}
