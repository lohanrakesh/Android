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
import com.example.shopping.HistroyModel
import com.example.shopping.ProductModel1
import com.example.shopping.R

class HistoryAdapter(var mCtx: Activity?, var models: List<HistroyModel>) : RecyclerView.Adapter<HistoryAdapter.CustomViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(mCtx).inflate(R.layout.item_history, parent, false)
        return CustomViewHolder(view)
    }

    override fun getItemCount(): Int {
        return models.size
    }

    inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvTransaction: TextView
        var tvDate: TextView
        var tvAdd: TextView
        init {
            tvTransaction = itemView.findViewById(R.id.tvTransaction)
            tvDate = itemView.findViewById(R.id.tvDate)
            tvAdd = itemView.findViewById(R.id.tvAdd)

        }
    }

    override   fun onBindViewHolder(holder: HistoryAdapter.CustomViewHolder, position: Int) {
        val model = models[position]
        holder.tvTransaction.text = model.transctionId.toString()
        holder.tvDate.text = model.date
        holder.tvAdd.text=model.address


    }
}