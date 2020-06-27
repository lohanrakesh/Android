package Helper

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shopping.ProductModel1
import com.example.shopping.R

class ProductNewAdapter(var mCtx: Activity?, var models: List<ProductModel1>) : RecyclerView.Adapter<ProductNewAdapter.CustomViewHolder>() {
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

        var tvAdd : TextView
        var tvSub: TextView
        var tvQty: TextView
        var button: Button


        init {
            tvName = itemView.findViewById(R.id.tvName)
            tvDetail = itemView.findViewById(R.id.tvDetail)
            tvPrice = itemView.findViewById(R.id.tvPrice)
            tvQuantity = itemView.findViewById(R.id.tvQuantity)
            tvQuantity.visibility=View.GONE
            ivProductImage = itemView.findViewById(R.id.imageView)
            llRoot = itemView.findViewById(R.id.llRoot)

            tvAdd = itemView.findViewById(R.id.tvAdd)
            tvSub = itemView.findViewById(R.id.tvSub)
            tvQty = itemView.findViewById(R.id.tvQty)
            button = itemView.findViewById(R.id.button)
        }
    }

    override   fun onBindViewHolder(holder: ProductNewAdapter.CustomViewHolder, position: Int) {
        val model = models[position]
        holder.tvName.text = model.productName
        holder.tvDetail.text = model.description
        holder.tvQty.text=model.quantityInCart.toString()

        holder.tvPrice.text="Rs. "+model.price.toString()

       /* holder.llRoot.setOnClickListener(View.OnClickListener {
          Toast.makeText(mCtx,"WIP", Toast.LENGTH_LONG).show()
        })*/

        if(model.isAddedToCart==0){
            holder.button.text="Add to card"
        }else{
            holder.button.text="Remove from card"
        }

        Utils.laodGlide(mCtx,model.image1,holder.ivProductImage)

        holder.tvAdd.setOnClickListener {
            (mCtx as ClickPosInter).click(position,true)
        }

        holder.button.setOnClickListener {
            (mCtx as ClickPosInter).add(position,model)
        }

        holder.tvSub.setOnClickListener {
            if(model.quantityInCart>=1){
                model.quantityInCart--
                holder.tvQty.text=model.quantityInCart.toString()
            }
        }
    }
}