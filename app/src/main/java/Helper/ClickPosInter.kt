package Helper

import com.example.shopping.ProductModel1

interface ClickPosInter {
    fun click( pos:Int,isAdd: Boolean,model1: ProductModel1)
    fun add( pos:Int,model1: ProductModel1)
}