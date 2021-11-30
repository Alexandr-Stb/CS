package com.example.cs

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.LinearLayout
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_layout.*
import kotlinx.android.synthetic.main.main_content.*

class MainActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener{
    var segment:String = ""
    var adapter:MyAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigation_view.setNavigationItemSelectedListener(this)

        var list = ArrayList<ListItem>()
        list.addAll(fillArray(resources.getStringArray(R.array.team_cis),
            getImageId(R.array.team_logo_cis)))
        recykleView.hasFixedSize()
        recykleView.layoutManager = LinearLayoutManager(this)

        button_openMenu.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }



        adapter = MyAdapter(list,this,segment)
        recykleView.adapter = adapter

    }

    private fun fillArray(titleArray: Array<String>, imageArray: IntArray):List<ListItem>{
        var listItemArray = ArrayList<ListItem>()
        for (n in titleArray.indices){
            var listItem = ListItem(imageArray[n],titleArray[n])
            listItemArray.add(listItem)
        }
        return listItemArray
    }

    private fun getImageId(imageArrayId:Int):IntArray{
        var tArray:TypedArray = resources.obtainTypedArray(imageArrayId)
        val count = tArray.length()
        val ids = IntArray(count)
        for (i in ids.indices){
            ids[i] = tArray.getResourceId(i,0)
        }
        tArray.recycle()
        return ids

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.cis -> {
                adapter?.segment= "CIS"

                adapter?.updateAdapter(fillArray(resources.getStringArray(R.array.team_cis),    getImageId(R.array.team_logo_cis)))
                adapter?.updateAdapter(fillArray(resources.getStringArray(R.array.team_cis),
                    getImageId(R.array.team_logo_cis)))


            }
            R.id.china -> {
                adapter?.segment = "CHINA"
                adapter?.updateAdapter(fillArray(resources.getStringArray(R.array.team_china),
                    getImageId(R.array.team_logo_china)))

            }
            R.id.usa -> {
                adapter?.segment = "USA"
                adapter?.updateAdapter(fillArray(resources.getStringArray(R.array.team_usa),
                    getImageId(R.array.team_logo_usa)))

            }
            R.id.europe -> {
                adapter?.segment = "EUROPE"
                adapter?.updateAdapter(fillArray(resources.getStringArray(R.array.team_europe),
                    getImageId(R.array.team_logo_europe)))

            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }


}