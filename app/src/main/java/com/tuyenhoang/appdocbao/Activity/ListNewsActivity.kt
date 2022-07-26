package com.tuyenhoang.appdocbao.Activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.tuyenhoang.appdocbao.Adapter.ListNewsAdapter
import com.tuyenhoang.appdocbao.test.ModelListNews
import com.tuyenhoang.appdocbao.test.ModelSub
import com.tuyenhoang.appdocbao.R
import com.tuyenhoang.appdocbao.databinding.ActivityListNewsBinding

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import org.jsoup.Jsoup
import java.lang.Exception

class ListNewsActivity : AppCompatActivity(), ListNewsAdapter.IListNews {

    private lateinit var binding: ActivityListNewsBinding
    private var listListNews = mutableListOf<ModelListNews>()
    private var link = String()
    private var tg = String()
    private var a = 1

    @SuppressLint("SetTextI18n", "NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_list_news)
        val listSub = intent.getSerializableExtra("dataSub") as ModelSub
        link = listSub.linkHtml
        tg = link
        binding.listNewsTitle.text = listSub.title
        readData(listSub.linkHtml)
        binding.listNewsRv.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.listNewsRv.adapter = ListNewsAdapter(this)
        binding.listNewsAdd.setOnClickListener {
            a++
            link = "$link-p$a"
            getDataSyn()
            binding.listNewsRv.adapter?.notifyDataSetChanged()
            link = tg
        }
        getDataSyn()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun getDataSyn() {
        Observable.create<MutableList<ModelListNews>> {
            it.onNext(
                readData(link)
            )
            it.onComplete()
        }.subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                binding.listNewsRv.adapter?.notifyDataSetChanged()
            }
    }

    private fun readData(linkHtml: String): MutableList<ModelListNews> {
        try {
            val doc = Jsoup.connect(linkHtml).get()
            val listnewfolder = doc.select("div.width_common")[2]
            val listar = listnewfolder?.getElementsByTag("article")
            for (i in 0..listar!!.size) {
                val title = listar[i].getElementsByTag("a")[0].attr("title").toString()
                val linkWeb = listar[i].getElementsByTag("a")[0].attr("href").toString()
                var linkImage =
                    listar[i].getElementsByTag("a")[0].getElementsByTag("img").attr("data-src")
                        .toString()
                if (linkImage.length < 10) {
                    linkImage =
                        listar[i].getElementsByTag("a")[0].getElementsByTag("img").attr("src")
                            .toString()
                }
                val content = listar[i].getElementsByTag("a")[2].text()
                listListNews.add(ModelListNews(title, content, linkImage, linkWeb))
            }
        } catch (e: Exception) {
        }
        return listListNews
    }

    override fun getCount() = listListNews.size
    override fun getItem(position: Int) = listListNews[position]
    override fun setClick(position: Int) {
        val intent = Intent(applicationContext, ContentActivity::class.java)
        intent.putExtra("dataNews", listListNews[position])
        startActivity(intent)
    }


}