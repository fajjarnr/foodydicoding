package com.fajar.foody

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.content_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(toolbar)

        val myData = intent.getParcelableExtra(extra_data) as Data
        supportActionBar?.title = myData.nama_makanan.toString()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        tv_detail_description.text = myData.deskripsi_makanan.toString()
        Glide.with(this)
            .load(myData.photo_makanan.toString())
            .apply(RequestOptions().override(700, 700))
            .into(iv_detail_photo)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    companion object {
        const val extra_data = "extra_mydata"
    }
}
