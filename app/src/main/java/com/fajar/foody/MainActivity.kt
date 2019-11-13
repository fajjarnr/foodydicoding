package com.fajar.foody

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        avatar.setOnClickListener() {
            val profile = Intent(this, ProfileActivity::class.java)
            startActivity(profile)
        }

        rv_data.setHasFixedSize(true)
        list.addAll(getListData())
        showRecyclerList()
    }

    fun getListData(): ArrayList<Data> {
        val dataName = resources.getStringArray(R.array.nama_makanan)
        val dataDescription = resources.getStringArray(R.array.deskripsi_makanan)
        val dataPhoto = resources.getStringArray(R.array.photo_makanan)
        val ListData = ArrayList<Data>()
        for (position in dataName.indices) {
            val Data = Data(
                dataName[position],
                dataDescription[position],
                dataPhoto[position]
            )
            ListData.add(Data)
        }
        return ListData
    }

    private fun showRecyclerList() {
        rv_data.layoutManager = LinearLayoutManager(this)
        val ListData = ListData(list, this@MainActivity)
        rv_data . adapter = ListData
    }

    private val list = ArrayList<Data>()
}
