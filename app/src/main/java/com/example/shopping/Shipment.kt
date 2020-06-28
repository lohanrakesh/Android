package com.example.shopping

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth



class Shipment : AppCompatActivity() {

    //UI elements
    private var etAdd: EditText? = null
    private var btnPay: Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shipment)
        initialise()
    }
    private fun initialise() {
        etAdd = findViewById<EditText>(R.id.etAdd) as EditText
        btnPay = findViewById<View>(R.id.btnPay) as Button

        btnPay!!
            .setOnClickListener {

                if(TextUtils.isEmpty(etAdd!!.text.toString())){
                    Toast.makeText(this@Shipment,"Please enter address",Toast.LENGTH_LONG).show()
                }else{
                    updateUI()
                }

            }

    }

    private fun updateUI() {
        val intent = Intent(this@Shipment, HistoryList::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
}
