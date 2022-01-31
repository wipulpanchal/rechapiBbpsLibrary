package rechapi.bbps.bbpslibrary.model;

import android.content.Context;

import java.util.ArrayList;

public class SubCategoriesOne {

    private String image;
    private String name;
    Context context;


    public SubCategoriesOne( Context context,String s, String i) {
        this.context=context;
        this.name = s;
        this.image = i;
    }
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
