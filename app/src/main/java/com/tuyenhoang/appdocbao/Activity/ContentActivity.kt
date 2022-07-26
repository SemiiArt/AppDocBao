package com.tuyenhoang.appdocbao.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.tuyenhoang.appdocbao.test.ModelListNews
import com.tuyenhoang.appdocbao.R
import com.tuyenhoang.appdocbao.databinding.ActivityContentBinding
import org.jsoup.Jsoup
import kotlin.concurrent.thread

class ContentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityContentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_content)
        val list = intent.getSerializableExtra("dataNews") as ModelListNews
        Glide.with(applicationContext)
            .load(list.linkImage)
            .error(R.drawable.img)
            .placeholder(R.drawable.img)
            .into(binding.contentImage)

        binding.contentTitle.text = list.title
        readData(list.linkHtml)
    }

    private fun readData(linkHtml: String) {
        thread {
            try {
                val doc = Jsoup.connect(linkHtml).get()
                val description = doc.select("div.sidebar-1")[0].getElementsByTag("p")[0].text()
                val contents =
                    doc.select("div.sidebar-1")[0].getElementsByTag("article")[0].getElementsByTag("p")
                var content = String()
                var i = 0
                while (i < contents.size) {
                    content = content.plus("\n").plus(contents[i].text())
                    i++
                }
                this.runOnUiThread {
                    binding.contentDescription.text = description
                    binding.contentContent.text = content
                }
            } catch (e: Exception) {
            }
        }
    }

}