package me.doapps.todoapps.utils;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by jonathan on 13/04/2015.
 */
public class FontUtil {
    public static Typeface setRalewayLight(Context context){
        return Typeface.createFromAsset(context.getAssets(), "fonts/Raleway-Light.ttf");
    }

    public static Typeface setRalewayRegular(Context context){
        return Typeface.createFromAsset(context.getAssets(), "fonts/Raleway-Regular.ttf");
    }

    public static Typeface setRalewayExtraBold(Context context){
        return Typeface.createFromAsset(context.getAssets(), "fonts/Raleway-ExtraBold.ttf");
    }
}
