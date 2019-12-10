package com.pavel.recycleviewitemdecoration

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.pavel.recycledecorate.EqualSpacingItemDecoration
import com.pavel.recycledecorate.MiddleDividerItemDecoration
import com.pavel.recycleviewitemdecoration.adapter.DashboardAdapter
import com.pavel.recycleviewitemdecoration.pojo.DashboardItems

import kotlinx.android.synthetic.main.activity_equal_item.*
import kotlinx.android.synthetic.main.activity_equal_item.toolbar
import kotlinx.android.synthetic.main.activity_middle_divider.*
import kotlinx.android.synthetic.main.content_middle_divider.*
import java.util.ArrayList

class EqualItemActivity : AppCompatActivity() {

    var dashboardItemsArrayList: ArrayList<DashboardItems>? = null
    var adapter: DashboardAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_middle_divider)
        setSupportActionBar(toolbar)

        dashboardItemsArrayList = ArrayList()


        dashboardItemsArrayList!!.add(DashboardItems("" + resources.getString(R.string.prescription), R.drawable.ic_prescription))
        dashboardItemsArrayList!!.add(DashboardItems("" + resources.getString(R.string.prescription), R.drawable.ic_prescription))
        dashboardItemsArrayList!!.add(DashboardItems("" + resources.getString(R.string.prescription), R.drawable.ic_prescription))
        dashboardItemsArrayList!!.add(DashboardItems("" + resources.getString(R.string.prescription), R.drawable.ic_prescription))
        dashboardItemsArrayList!!.add(DashboardItems("" + resources.getString(R.string.prescription), R.drawable.ic_prescription))
        dashboardItemsArrayList!!.add(DashboardItems("" + resources.getString(R.string.prescription), R.drawable.ic_prescription))
        dashboardItemsArrayList!!.add(DashboardItems("" + resources.getString(R.string.prescription), R.drawable.ic_prescription))
        dashboardItemsArrayList!!.add(DashboardItems("" + resources.getString(R.string.prescription), R.drawable.ic_prescription))


        recycleview.setHasFixedSize(true)

        recycleview!!.addItemDecoration(EqualSpacingItemDecoration(30, EqualSpacingItemDecoration.GRID))
        recycleview!!.layoutManager = GridLayoutManager(applicationContext, 2)

        adapter = DashboardAdapter(applicationContext, dashboardItemsArrayList)
        recycleview!!.adapter = adapter

    }
}