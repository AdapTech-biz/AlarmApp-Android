package com.example.xyd93.amjumpstart

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_classic_alarm.*
import kotlinx.android.synthetic.main.days_of_week_classic.view.*
import java.util.*

class ClassicAlarmActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_classic_alarm)

//        val name = intent.getStringExtra("My Name")
//        Toast.makeText(this, name, Toast.LENGTH_SHORT).show()

        val recyclerView = days_recycler_classic
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CustomerAdapter(this)

        time_picker_classic.setOnTimeChangedListener { timePicker, hour, min ->
            println(hour)
            println(min)




        }

    }

    fun backBtnPressed(view: View){
        finish()
    }

    fun nextBtnPressed(view: View){
        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(this.applicationContext, SystemAlarm::class.java)
        val alarmIntent = PendingIntent.getBroadcast(applicationContext, 0, intent, 0)

        val calendar = Calendar.getInstance()
        calendar.timeInMillis = System.currentTimeMillis()
        calendar.set(Calendar.HOUR_OF_DAY, time_picker_classic.currentHour)
        calendar.set(Calendar.MINUTE, time_picker_classic.currentMinute)
        Log.d("AlarmTime", calendar.time.toString())
// setRepeating() lets you specify a precise custom interval--in this case,
// 20 minutes.
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.timeInMillis,
                0, alarmIntent)

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
        p0.itemView.setOnClickListener {
            p0.itemView.day_checked_classic.isChecked = !p0.itemView.day_checked_classic.isChecked
        }

    }



}

private class WeekDaysHolder(v: View): RecyclerView.ViewHolder(v), View.OnClickListener{

    override fun onClick(p0: View?) {
    }
}
