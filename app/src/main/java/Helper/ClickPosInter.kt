package Helper

import com.example.shopping.ProductModel1

interface ClickPosInter {
    fun click( pos:Int,isAdd: Boolean)
    fun add( pos:Int,model1: ProductModel1)
}