package com.tuyenhoang.appdocbao.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.tuyenhoang.appdocbao.Adapter.WebsiteAdapter
import com.tuyenhoang.appdocbao.test.ModelWebsite
import com.tuyenhoang.appdocbao.R
import com.tuyenhoang.appdocbao.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), WebsiteAdapter.IWebsite {
    private var listWebsite = mutableListOf<ModelWebsite>()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initData()
        binding.rcWeb.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rcWeb.adapter = WebsiteAdapter(this)
    }

    fun initData() {
        listWebsite.add(
            ModelWebsite(
                "Vnexpress.net",
                "https://vnexpress.net/", "https://toplist.vn/images/800px/vnexpressnet-23999.jpg"
            )
        )
        listWebsite.add(
            ModelWebsite(
                "News.zing.vn",
                "https://news.zing.vn/", "https://toplist.vn/images/800px/newszingvn-23993.jpg"
            )
        )
        listWebsite.add(
            ModelWebsite(
                "Dantri.com.vn",
                "http://dantri.com.vn/", "https://toplist.vn/images/800px/dantricomvn-24003.jpg"
            )
        )
        listWebsite.add(
            ModelWebsite(
                "24h.com.vn",
                "https://www.24h.com.vn/", "https://toplist.vn/images/800px/vnexpressnet-23998.jpg"
            )
        )
        listWebsite.add(
            ModelWebsite(
                "Vietnamnet.vn",
                "http://vietnamnet.vn/", "https://toplist.vn/images/800px/vietnamnetvn-24006.jpg"
            )
        )
        listWebsite.add(
            ModelWebsite(
                "Laodong.com.vn",
                "https://laodong.vn/", "https://toplist.vn/images/800px/laodongcomvn-24023.jpg"
            )
        )
        listWebsite.add(
            ModelWebsite(
                "Baomoi.com",
                "https://baomoi.com/", "https://toplist.vn/images/800px/tuoitrevn-24008.jpg"
            )
        )
        listWebsite.add(
            ModelWebsite(
                "Tuoitre.vn",
                "https://tuoitre.vn/", "https://toplist.vn/images/800px/tuoitrevn-24014.jpg"
            )
        )
        listWebsite.add(
            ModelWebsite(
                "Thanhnien.vn",
                "https://thanhnien.vn/", "https://toplist.vn/images/800px/thanhnienvn-24027.jpg"
            )
        )
        listWebsite.add(
            ModelWebsite(
                "Kenh14.vn",
                "http://kenh14.vn/", "https://toplist.vn/images/800px/kenh14vn-24034.jpg"
            )
        )

    }

    override fun getCount() = listWebsite.size

    override fun getItem(position: Int) = listWebsite[position]

    override fun setClick(position: Int) {
        val intent = Intent(applicationContext, MainNavActivity::class.java)
        startActivity(intent)
    }
}