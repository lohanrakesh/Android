package Helper;

import android.content.Context;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import java.io.IOException;
import java.io.InputStream;

public class Utils {

  public static String getJsonFromAssets(Context context, String fileName) {
    String jsonString;
    try {
      InputStream is = context.getAssets().open(fileName);

      int size = is.available();
      byte[] buffer = new byte[size];
      is.read(buffer);
      is.close();

      jsonString = new String(buffer, "UTF-8");
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }

    return jsonString;
  }

  public  static void laodGlide(Context context, String url, ImageView imageView){
    Glide.with(context)
            .load(url)
            .skipMemoryCache(true)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .into(imageView);
  }

}