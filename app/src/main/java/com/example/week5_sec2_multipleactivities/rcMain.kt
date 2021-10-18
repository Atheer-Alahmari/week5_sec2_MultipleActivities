package com.example.week5_sec2_multipleactivities

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class rcMain : AppCompatActivity() {
    lateinit var list_RV: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rc_main)

        list_RV=findViewById(R.id.recycler_View)// Recycler View

        val fn=intent.getStringExtra("sendFName")
        val ln=intent.getStringExtra("sendLName")
        val loc=intent.getStringExtra("sendLoc")
        val num=intent.getStringExtra("sendNum")


        var list=ArrayList<String>()

        list_RV.adapter=RV_Adabter(list)
        list_RV.layoutManager= LinearLayoutManager(this)

        list.add(fn.toString())
        list.add(ln.toString())
        list.add(loc.toString())
        list.add(num.toString())


      //  list_RV.adapter?.notifyDataSetChanged()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.mymenu, menu)
        return super.onCreateOptionsMenu(menu)

    }

    fun menuA(item: android.view.MenuItem) {
        var alt = AlertDialog.Builder(this)
        alt.setTitle("Where you want to go!!")
        alt.setPositiveButton("Home", DialogInterface.OnClickListener { _, _ ->
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })
        alt.setNegativeButton("Exit", DialogInterface.OnClickListener { _, _ ->
           System.exit(0)
        })

        val alt1: AlertDialog = alt.create()
        alt1.setCanceledOnTouchOutside(false)
        alt1.show()
    }


}