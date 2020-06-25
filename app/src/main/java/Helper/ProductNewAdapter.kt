package Helper

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.shopping.ProductModel
import com.example.shopping.R

class ProductNewAdapter(var mCtx: Activity?, var models: List<ProductModel>) : RecyclerView.Adapter<ProductNewAdapter.CustomViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(mCtx).inflate(R.layout.item_product, parent, false)
        return CustomViewHolder(view)
    }

    override fun getItemCount(): Int {
        return models.size
    }

    inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView
        var tvDetail: TextView
        var tvPrice: TextView
        var tvQuantity: TextView
        var ivProductImage: ImageView
        var llRoot: LinearLayout


        init {
            tvName = itemView.findViewById(R.id.tvName)
            tvDetail = itemView.findViewById(R.id.tvDetail)
            tvPrice = itemView.findViewById(R.id.tvPrice)
            tvQuantity = itemView.findViewById(R.id.tvQuantity)
            ivProductImage = itemView.findViewById(R.id.imageView)
            llRoot = itemView.findViewById(R.id.llRoot)
        }
    }

    override   fun onBindViewHolder(holder: ProductNewAdapter.CustomViewHolder, position: Int) {
        val model = models[position]
        holder.tvName.text = model.name
        holder.tvDetail.text = model.detail

        holder.llRoot.setOnClickListener(View.OnClickListener {
          Toast.makeText(mCtx,"WIP", Toast.LENGTH_LONG).show()
        })
    }
}