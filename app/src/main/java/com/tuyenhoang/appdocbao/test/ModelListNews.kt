package com.tuyenhoang.appdocbao.test

import java.io.Serializable

data class ModelListNews(
    var title: String,
    var content: String,
    var linkImage: String,
    var linkHtml: String
):Serializable {
}