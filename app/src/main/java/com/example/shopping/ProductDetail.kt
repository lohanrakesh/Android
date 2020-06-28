package com.example.shopping

import Helper.SharePrefUtils
import Helper.Utils
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener
import kotlinx.android.synthetic.main.activity_product_detail.*


class ProductDetail : AppCompatActivity() {

    /*var sampleImages = intArrayOf(
        R.drawable.image_1,
        R.drawable.image_2
    )*/
    var sampleImages1 = arrayOf<String>(
        "",
        ""
    )
    lateinit var model1:ProductModel1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)
        model1=intent.getSerializableExtra(SharePrefUtils.PERF_KEY_PUT_EXTRA) as ProductModel1
        tvPrice.setText("Rs. "+model1.price)
        tvDetail.setText(model1.description)
        tvName.setText(model1.productName)

        sampleImages1[0]=model1.image1
        sampleImages1[1]=model1.image2

        val carouselView = findViewById(R.id.carouselView) as CarouselView;
        carouselView.setPageCount(sampleImages1.size);
        carouselView.setImageListener(imageListener);
    }


    var imageListener: ImageListener = object : ImageListener {
        override fun setImageForPosition(position: Int, imageView: ImageView) {
            // You can use Glide or Picasso here
           // imageView.setImageResource(sampleImages[position])
            Utils.laodGlide(this@ProductDetail,sampleImages1[position],imageView)
        }
    }
}
