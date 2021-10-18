package com.example.week5_sec2_multipleactivities

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.util.TypedValue
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_disply_main.*
import kotlinx.android.synthetic.main.activity_main.*

class displyMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_disply_main)

        val fn = intent.getStringExtra("sendFName")
        val ln = intent.getStringExtra("sendLName")
        val loc = intent.getStringExtra("sendLoc")
        val num = intent.getStringExtra("sendNum")

        fn_TV.setText("First Name: $fn")
        ln_TV.setText("Last Name: $ln")
        loc_TV.setText("Location: $loc")
        num_TV.setText("Phone No.: $num")
        btn_con.setOnClickListener {
            var alt = AlertDialog.Builder(this)
            alt.setTitle("Your Information")
            val mLayout = LinearLayout(this)
            var fname = TextView(this)
            var lname = TextView(this)
            var location = TextView(this)
            var number = TextView(this)


            fname.text = "First Name: $fn"
            lname.text = "Last Name: $ln"
            location.text = "Location: $loc"
            number.text = "Phone No.: $num"
            fname.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16f)
            lname.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16f)
            location.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16f)
            number.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16f)

            mLayout.orientation = LinearLayout.VERTICAL
            mLayout.addView(fname)
            mLayout.addView(lname)
            mLayout.addView(location)
            mLayout.addView(number)
            mLayout.setPadding(50, 40, 50, 10)

            alt.setView(mLayout)
            alt.setPositiveButton("Confirm", DialogInterface.OnClickListener { _, _ ->
                var intent = Intent(this, rcMain::class.java)
                intent.putExtra("sendFName", fn)
                intent.putExtra("sendLName", ln)
                intent.putExtra("sendLoc", loc)
                intent.putExtra("sendNum", num)
                startActivity(intent)

            })

            val alt1: AlertDialog = alt.create()
            alt1.setCanceledOnTouchOutside(false)
            alt1.show()

        }
    }
}