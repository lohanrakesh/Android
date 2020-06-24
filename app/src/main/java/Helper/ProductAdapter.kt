/*
package Helper

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shopping.R
import com.example.shopping.inflate
import kotlinx.android.synthetic.main.activity_product_row.view.*

class PhotoHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
    //2
    private var view: View = v
    private var photo: Photo? = null

    //3
    init {
        v.setOnClickListener(this)
    }

    //4
    override fun onClick(v: View) {
        Log.d("RecyclerView", "CLICK!")
    }

    companion object {
        //5
        private val PHOTO_KEY = "PHOTO"
    }

    fun bindPhoto(photo: Photo) {
        this.photo = photo
        Picasso.with(view.context).load(photo.url).into(view.itemImage)
        view.itemDate.text = photo.humanDate
        view.itemDescription.text = photo.explanation
    }
}

class ProductAdapter(private val layoutManager: GridLayoutManager? = null) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    enum class ViewType {
        SMALL,
        DETAILED
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ViewType.DETAILED.ordinal -> DetailedViewHolder(parent)
            else -> SimpleViewHolder(parent)
        }
    }

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
    }

    override fun getItemCount() = 5

    override fun getItemViewType(position: Int): Int {
        return if (layoutManager?.spanCount == 1) ViewType.DETAILED.ordinal
        else ViewType.SMALL.ordinal
    }
}
*/
