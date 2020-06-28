package com.example.shopping

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_account.*
import kotlinx.android.synthetic.main.activity_product_list.*

class Account : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        val user = FirebaseAuth.getInstance().currentUser
        if (user != null) {
            tvEmail.setText(user.email.toString())
        }

        btn_Logout.setOnClickListener({
            FirebaseAuth.getInstance().signOut()

            val intent = Intent(this@Account, ProductList::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        })
    }
}
