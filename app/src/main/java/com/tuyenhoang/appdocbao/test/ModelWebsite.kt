package com.tuyenhoang.appdocbao.test

import java.io.Serializable

data class ModelWebsite(
    var name: String,
    var linkHtml: String,
    var linkImage: String
):Serializable {
}