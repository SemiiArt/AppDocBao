package com.tuyenhoang.appdocbao.Activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.tuyenhoang.appdocbao.Adapter.SubAdapter
import com.tuyenhoang.appdocbao.test.ModelMainNav
import com.tuyenhoang.appdocbao.test.ModelSub
import com.tuyenhoang.appdocbao.R
import com.tuyenhoang.appdocbao.databinding.ActivitySubBinding

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import org.jsoup.Jsoup
import java.lang.Exception

class SubActivity : AppCompatActivity(), SubAdapter.ISub {
    private var listModelSub = mutableListOf<ModelSub>()
    private lateinit var binding: ActivitySubBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sub)
        val listMainNav = intent.getSerializableExtra("dataMainNav") as ModelMainNav
        binding.subMainNavText.text = listMainNav.title
        binding.subMainNavRv.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.subMainNavRv.adapter = SubAdapter(this)
        getDataSyn()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun getDataSyn() {
        val listMainNav = intent.getSerializableExtra("dataMainNav") as ModelMainNav
        Observable.create<MutableList<ModelSub>> {
            it.onNext(
                readDataSub(listMainNav.linkHtml)
            )
            it.onComplete()
        }.subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                binding.subMainNavRv.adapter?.notifyDataSetChanged()
            }
    }

    private fun readDataSub(link: String): MutableList<ModelSub> {
        val listMainNav = intent.getSerializableExtra("dataMainNav") as ModelMainNav
        try {
            val doc = Jsoup.connect(link).get()
            val listSub = doc.getElementsByClass("ul-nav-folder")
            val list = listSub[0].getElementsByTag("li")
            for (lists in list) {
                val title = lists.getElementsByTag("a").attr("title").toString()
                var linkHtml = lists.getElementsByTag("a").attr("href").toString()
                linkHtml = "https://vnexpress.net" + linkHtml
                listModelSub.add(ModelSub(title, linkHtml))
            }
        } catch (e: Exception) {

        }
        return listModelSub
    }

    override fun getCount() = listModelSub.size

    override fun getItem(position: Int) = listModelSub[position]

    override fun setClick(position: Int) {
        val intent = Intent(applicationContext, ListNewsActivity::class.java)
        intent.putExtra("dataSub", listModelSub[position])
        startActivity(intent)
    }
}