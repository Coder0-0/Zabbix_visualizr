package com.example.zabbixviewer

import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.zabbixviewer.R
import com.example.zabbixviewer.Problem_Fragment
import com.example.zabbixviewer.Dashboard_Fragment
import com.example.zabbixviewer.Hosts_Fragment
import com.example.zabbixviewer.Info_Fragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        var bottomNavigationView: BottomNavigationView? = null
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, Problem_Fragment()).commit()
        bottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.run {
            this?.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
                var fragment: Fragment? = null
                when (item.itemId) {
                    R.id.item1 -> fragment = Problem_Fragment()
                    R.id.item2 -> fragment = Dashboard_Fragment()
                    R.id.item3 -> fragment = Hosts_Fragment()
                    R.id.item4 -> fragment = Info_Fragment()
                }
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment!!).commit()
                true
            })
        }
    }
}