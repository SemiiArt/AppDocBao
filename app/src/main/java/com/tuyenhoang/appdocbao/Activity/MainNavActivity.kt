package com.tuyenhoang.appdocbao.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.tuyenhoang.appdocbao.Adapter.MainNavAdapter
import com.tuyenhoang.appdocbao.test.ModelMainNav
import com.tuyenhoang.appdocbao.R
import com.tuyenhoang.appdocbao.databinding.ActivitySecondBinding

class MainNavActivity : AppCompatActivity(), MainNavAdapter.IMainNav {
    private lateinit var binding: ActivitySecondBinding
    private var listMainNav = mutableListOf<ModelMainNav>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_second)
        initData()
        binding.rvMainnav.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvMainnav.adapter = MainNavAdapter(this)
    }

    private fun initData() {

        listMainNav.add(
            ModelMainNav(
                "Thời sự",
                "https://image.vtc.vn/resize/th/upload/2021/12/29/26960319715553163248490521453061228990665808n-09193796.jpg",
                "https://vnexpress.net/thoi-su"
            )
        )
        listMainNav.add(
            ModelMainNav(
                "Thế giới",
                "https://baoquocte.vn/stores/news_dataimages/minhchau/122016/29/14/143822_52-9-Anh_minh_hoa.jpg",
                "https://vnexpress.net/the-gioi"
            )
        )
        listMainNav.add(
            ModelMainNav(
                "Kinh doanh",
                "https://taxplus.vn/wp-content/uploads/2019/12/nen-hoc-cach-kinh-doanh-buon-ban-o-dau-1.jpg",
                "https://vnexpress.net/kinh-doanh"
            )
        )

        listMainNav.add(
            ModelMainNav(
                "Giải trí",
                "https://1.bp.blogspot.com/-gxfpWpzbt1Q/XfsGwqRr1fI/AAAAAAAAJYA/ZYbFCQbvMqw9QlWCFhjEPyBiTxZDqLV_gCLcBGAsYHQ/s1600/111oung-people-jumping-together-illustration_52683-27019.jpg",
                "https://vnexpress.net/giai-tri"
            )
        )
        listMainNav.add(
            ModelMainNav(
                "Thể thao",
                "https://bacdau.vn/wp-content/uploads/2020/04/top-5-game-bong-da-hay-nhat-5-1-730x430-1.jpg",
                "https://vnexpress.net/the-thao"
            )
        )
        listMainNav.add(
            ModelMainNav(
                "Pháp luật",
                "https://bcp.cdnchinhphu.vn/Uploaded/dothanhhoai/2020_09_25/phapluat.jpg",
                "https://vnexpress.net/phap-luat"
            )
        )
        listMainNav.add(
            ModelMainNav(
                "Giáo dục",
                "https://tuyensinhdonga.edu.vn/wp-content/uploads/2021/05/muc-tieu-cu-he-giao-duc-tieu-hoc.jpg",
                "https://vnexpress.net/giao-duc"
            )
        )
        listMainNav.add(
            ModelMainNav(
                "Khoa học",
                "https://datascience.edu.vn/wp-content/uploads/2019/03/Data-Science-vs.-Big-Data-vs-800x445.jpg",
                "https://vnexpress.net/khoa-hoc"
            )
        )
        listMainNav.add(
            ModelMainNav(
                "Sức khỏe",
                "https://kinhtechungkhoan.vn/stores/news_dataimages/thuuyen/082019/31/23/in_article/5234_thucpham1.jpg",
                "https://vnexpress.net/suc-khoe"
            )
        )
        listMainNav.add(
            ModelMainNav(
                "Đời sống",
                "https://vuonhoaphatgiao.com/uploads/noidung/images/van_hoa/lam-the-nao-de-co-doi-song-tai-gia-an-vui-hp.jpg",
                "https://vnexpress.net/doi-song"
            )
        )
        listMainNav.add(
            ModelMainNav(
                "Du lịch",
                "https://media.vneconomy.vn/images/upload/2022/01/20/du-lich.jpg",
                "https://vnexpress.net/du-lich"
            )
        )
        listMainNav.add(
            ModelMainNav(
                "Số hóa",
                "https://tino.org/wp-content/uploads/2021/08/word-image-123.jpeg",
                "https://vnexpress.net/so-hoa"
            )
        )
        listMainNav.add(
            ModelMainNav(
                "Xe",
                "https://vnn-imgs-f.vgcloud.vn/2020/10/21/10/huracan-la-mo-t-trong-nhu-ng-ma-u-xe-de-p-nha-t-cu-a-lamborghini-a-nh-autocar.jpg",
                "https://vnexpress.net/oto-xe-may"
            )
        )
        listMainNav.add(
            ModelMainNav(
                "Ý kiến",
                "https://miraway-cetm.com/wp-content/uploads/2018/07/khac-biet-giua-khao-sat-va-y-kien-phan-hoi-1.jpg",
                "https://vnexpress.net/y-kien"
            )
        )
        listMainNav.add(
            ModelMainNav(
                "Hài",
                "https://readvii.com/wp-content/uploads/2020/05/sach-day-hai-huoc-cover-780x470.png",
                "https://vnexpress.net/hai"
            )
        )
    }

    override fun getCount() = listMainNav.size

    override fun getItem(position: Int) = listMainNav[position]

    override fun setClick(position: Int) {
        val intent = Intent(applicationContext, SubActivity::class.java)
        intent.putExtra("dataMainNav", listMainNav[position])
        startActivity(intent)
    }


}