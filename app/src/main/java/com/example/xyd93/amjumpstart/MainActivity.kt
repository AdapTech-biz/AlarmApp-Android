package com.example.xyd93.amjumpstart

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.PopupMenu
import android.support.v7.widget.RecyclerView
import android.view.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.viewcell_main.view.*
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.setBackgroundColor(Color.BLUE)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ViewAdapter()


    }

    fun showMenuPopUp(v: View){
        val popupMenu = PopupMenu(this, v)
        popupMenu.inflate(R.menu.alarm_popup)
        popupMenu.show()

        popupMenu.setOnMenuItemClickListener {

            when(it.itemId){
                R.id.classic_alarm_menu ->{
                    Toast.makeText(this, "Classic", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, ClassicAlarmActivity::class.java)
                    startActivity(intent)
                }
                R.id.smart_alarm_menu -> {
                    Toast.makeText(this, "Smart Alarm", Toast.LENGTH_SHORT).show()
                }
                else ->{
                    Toast.makeText(this, "No valid selection", Toast.LENGTH_SHORT).show()

                }
            }

            true
        }

    }



}

private class ViewAdapter: RecyclerView.Adapter<CustomHolder>(){

    val names = arrayListOf("Xavier", "Cassandra", "Yarnell")
    val dob = arrayListOf("May 7, 1993", "December 16, 1993", "Feb 11, 2014")

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CustomHolder {

        val inflater = LayoutInflater.from(p0.context)
        val cell = inflater.inflate(R.layout.viewcell_main, p0, false)

        return CustomHolder(cell)

    }

    override fun getItemCount(): Int {
        return names.size
    }

    override fun onBindViewHolder(p0: CustomHolder, p1: Int) {
        p0.itemView.profile_name.text = names[p1]
        p0.itemView.date_of_birth.text = dob[p1]
    }
}

private class CustomHolder(view: View): RecyclerView.ViewHolder(view)
