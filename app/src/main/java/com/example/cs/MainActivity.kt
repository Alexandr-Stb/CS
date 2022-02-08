package com.example.cs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cs.data.Storage
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main_content.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    var adapter: MyAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Storage.context = this
        navigation_view.setNavigationItemSelectedListener(this)
        adapter = MyAdapter(Storage.teams, this)
        recycleView.adapter = adapter
        adapter?.updateAdapter(Storage.getRegionTeams(Storage.Regions.CIS))
        recycleView.hasFixedSize()
        recycleView.layoutManager = LinearLayoutManager(this)

        button_openMenu.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }


    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.cis -> {
                adapter?.updateAdapter(Storage.getRegionTeams(Storage.Regions.CIS))
            }
            R.id.china -> {
                adapter?.updateAdapter(Storage.getRegionTeams(Storage.Regions.CHINA))
            }
            R.id.europe ->{
                adapter?.updateAdapter(Storage.getRegionTeams((Storage.Regions.EUROPE)))
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }


}