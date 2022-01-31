package rechapi.bbps.bbpslibrary.sharedPreferenceData;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.Set;

public class DataProccessor {

    private static Context context;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;

    public DataProccessor(Context context){
        this.context = context;
    }

    public final static String PREFS_NAME = "appname_prefs";

    public boolean sharedPreferenceExist(String key)
    {
       //  prefs = context.getSharedPreferences(PREFS_NAME, 0);
        if(!prefs.contains(key)){
            return true;
        }
        else {
            return false;
        }
    }

    public  void setInt_sub_cat_size(Set<String> value) {
        prefs=context.getSharedPreferences("helloBudy", Context.MODE_PRIVATE);
        editor = prefs.edit();
        editor.putStringSet("int_sub_cat_filterlist", (Set<String>) value);
        editor.commit();
    }

    public Set<String> getInt_sub_cat_size() {
        prefs=context.getSharedPreferences("helloBudy", Context.MODE_PRIVATE);
        return prefs.getStringSet("int_sub_cat_filterlist",null);
    }

    public  void setStr(String key, String value) {
        prefs=context.getSharedPreferences(PREFS_NAME, 0);
        editor = prefs.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public  String getStr(String key) {
        prefs=context.getSharedPreferences(PREFS_NAME, 0);
        return prefs.getString(key,"DNF");
    }

    public  void setBool(String key, boolean value) {
        prefs=context.getSharedPreferences(PREFS_NAME, 0);
         editor = prefs.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public  boolean getBool(String key) {
        prefs=context.getSharedPreferences(PREFS_NAME, 0);
        return prefs.getBoolean(key,false);
    }
}
