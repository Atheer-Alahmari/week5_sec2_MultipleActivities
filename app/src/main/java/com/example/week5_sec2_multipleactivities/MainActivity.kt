package com.example.week5_sec2_multipleactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btn_SU.setOnClickListener {
            if (agree_CB.isChecked) {
                var fn = fName_ED.text.toString()
                var ln = lName_ED.text.toString()
                var loc = loc_ED.text.toString()
                var no = num_ED.text.toString()

                var intent = Intent(this, displyMain::class.java)
                intent.putExtra("sendFName", fn)
                intent.putExtra("sendLName", ln)
                intent.putExtra("sendLoc", loc)
                intent.putExtra("sendNum", no)
                startActivity(intent)

            } else {
                var alt = AlertDialog.Builder(this)
                alt.setTitle("Notification")
                alt.setMessage("Please  Checked in agree box First")
                val alt1: AlertDialog = alt.create()
                alt1.show()
            }
        }
    }
}