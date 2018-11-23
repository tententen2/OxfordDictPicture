package com.jirawatpoo.oxforddictpicture.main.model

data class DisplayDetailData(
    val listDetailData: ArrayList<InsideDetailData>
)

data class InsideDetailData(
    val lexicalCategory:String,
    val definition: String,
    val pronunciation: String
)

