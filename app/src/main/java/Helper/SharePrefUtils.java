package Helper;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Used for utility methods related to sharedPref
 */

public class SharePrefUtils {

    private static final String MY_PREFERENCES = "MyPrefs";
    public static final String PERF_KEY_PRODUCT = "PERF_KEY_PRODUCT";
    public static final String PERF_KEY_PUT_EXTRA = "PERF_KEY_PUT_EXTRA";

    public static final String productId = "productId";
    public static final String productName = "productName";
    public static final String productCode = "productCode";
    public static final String releaseDate = "releaseDate";
    public static final String description = "description";
    public static final String price = "price";
    public static final String quantityInCart = "quantityInCart";
    public static final String maxQuantity = "maxQuantity";
    public static final String isAddedToCart = "isAddedToCart";
    public static final String image1 = "image1";
    public static final String image2 = "image2";



    private static SharedPreferences sharedpreferences;

    private SharePrefUtils() {
    }

    public static void setString(Context context, String key, String value){
        sharedpreferences=  context.getSharedPreferences(MY_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }
    public static void setInt(Context context, String key, int value){
        sharedpreferences=  context.getSharedPreferences(MY_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }
    public static void setBool(Context context, String key, boolean value){
        sharedpreferences=  context.getSharedPreferences(MY_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }
    public static String getString(Context context, String key, String defaultVal){
        sharedpreferences=  context.getSharedPreferences(MY_PREFERENCES, Context.MODE_PRIVATE);
        return sharedpreferences.getString(key,defaultVal);
    }

    public static int getInt(Context context, String key, int defaultVal){
        sharedpreferences=  context.getSharedPreferences(MY_PREFERENCES, Context.MODE_PRIVATE);
        return sharedpreferences.getInt(key,defaultVal);
    }

    public static long getLong(Context context, String key, long defaultVal){
        sharedpreferences=  context.getSharedPreferences(MY_PREFERENCES, Context.MODE_PRIVATE);
        return sharedpreferences.getLong(key,defaultVal);
    }

    public static void setLong(Context context, String key, long value){
        sharedpreferences=  context.getSharedPreferences(MY_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putLong(key, value);
        editor.apply();
    }

    public static boolean getBoolean(Context context, String key, boolean defaultVal){
        sharedpreferences=  context.getSharedPreferences(MY_PREFERENCES, Context.MODE_PRIVATE);
        return sharedpreferences.getBoolean(key,defaultVal);
    }

}
