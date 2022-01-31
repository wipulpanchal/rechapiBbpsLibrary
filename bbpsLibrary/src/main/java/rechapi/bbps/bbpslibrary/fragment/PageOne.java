package rechapi.bbps.bbpslibrary.fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import rechapi.bbps.bbpslibrary.R;

public class PageOne extends Fragment {

    private  ImageView imageView;
    private EditText ettext_consumer_no,editText_pin_no;
    private TextView txtimage_name;

    Object name,image;


    public PageOne(Object obj_name,Object obj_imaghe) {
        // required empty public constructor.
        this.name=obj_name;
        this.image=obj_imaghe;

    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.fragment_page1,container,false);

       imageView=(ImageView) view.findViewById(R.id.waterimg);
       ettext_consumer_no=(EditText) view.findViewById(R.id.consumernumber);
       editText_pin_no=(EditText) view.findViewById(R.id.fourdigits);
       txtimage_name=(TextView) view.findViewById(R.id.imgtxt);

      /* String img=getArguments().getString("img");
       String imgname=getArguments().getString("imgName");
       txtimage_name.setText(imgname);
       Glide.with(getContext()).load(img).into(imageView);*/

        txtimage_name.setText(name.toString());
        Glide.with(getContext()).load(image).into(imageView);

        return view;
    }
}
