package com.example.xyd93.amjumpstart

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_classic_alarm.*
import kotlinx.android.synthetic.main.days_of_week_classic.view.*

class ClassicAlarmActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_classic_alarm)

        val name = intent.getStringExtra("My Name")
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show()

        val recyclerView = days_recycler_classic
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CustomerAdapter(this)

    }

    fun backBtnPressed(view: View){
        finish()
    }
}

private class CustomerAdapter(var context: Context): RecyclerView.Adapter<WeekDaysHolder>(){



    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): WeekDaysHolder {
        val layoutInflater = LayoutInflater.from(context)
       val view = layoutInflater.inflate(R.layout.days_of_week_classic, p0, false)
        return WeekDaysHolder(view)

    }

    override fun getItemCount(): Int {
        return DaysOfWeek.values().size
    }

    override fun onBindViewHolder(p0: WeekDaysHolder, p1: Int) {

        p0.itemView.day_classic.text = DaysOfWeek.values()[p1].toString()

    }


}

private class WeekDaysHolder(v: View): RecyclerView.ViewHolder(v), View.OnClickListener{

    override fun onClick(p0: View?) {
       println("tapped registered")
    }
}
