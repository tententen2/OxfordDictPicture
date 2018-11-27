package com.jirawatpoo.domain.model

data class DataDictImagePresent(
    val data: Data,
    val status: String // success
)

data class Data(
    val cache: Cache,
    val result: ResultImage
)

data class Cache(
    val age: Int, // 0
    val created: Int, // 1542960563
    val expiration: Int, // 2592000
    val key: String, // 3647bb6ed34c6b2bf49d09f8834ecdf8
    val status: String // miss
)

data class ResultImage(
    val items: List<Item>
)

data class Item(
    val id: String, // 083058bb98f46cce3351466da1c8e834
    val bId: String, // OIP.E2SgIaHimZtoe4TmtWrpFgHaGC
    val count: Int, // 4
    val desc: String,
    val height: String, // 1072
    val media: String, // https://upload.wikimedia.org/wikipedia/commons/e/e6/Lida%2C_Nevada_abandon_house.jpg
    val mediaFullsize: String, // //s2.qwant.com/thumbr/0x0/4/c/5a97d9785dc348902d33ea289075dc4bb5730563d9a86755b5bae6552f59d6/Lida%2C_Nevada_abandon_house.jpg?u=https%3A%2F%2Fupload.wikimedia.org%2Fwikipedia%2Fcommons%2Fe%2Fe6%2FLida%252C_Nevada_abandon_house.jpg&q=0&b=1&p=0&a=1
    val mediaPreview: String, // //s2.qwant.com/thumbr/0x380/4/2/6fcbfaab1c9cb9ba68a18d754e4e495b27e74a7747a165e095f65c6a02e996/Lida%2C_Nevada_abandon_house.jpg?u=https%3A%2F%2Fupload.wikimedia.org%2Fwikipedia%2Fcommons%2Fe%2Fe6%2FLida%252C_Nevada_abandon_house.jpg&q=0&b=1&p=0&a=1
    val size: String, // 456427
    val thumbHeight: Int, // 200
    val thumbType: String, // jpg
    val thumbWidth: Int, // 245
    val thumbnail: String, // //s1.qwant.com/thumbr/245x200/0/c/1def7eaf1b9e9d22299438421d11e99f551a3d8a2daadc7b98aabc3eebf5bf/Lida%2C_Nevada_abandon_house.jpg?u=https%3A%2F%2Fupload.wikimedia.org%2Fwikipedia%2Fcommons%2Fe%2Fe6%2FLida%252C_Nevada_abandon_house.jpg&q=0&b=1&p=0&a=0&b_id=OIP.E2SgIaHimZtoe4TmtWrpFgHaGC
    val title: String, // File:Lida, Nevada abandon house.jpg - Wikimedia Commons
    val type: String, // image
    val url: String, // http://commons.wikimedia.org/wiki/File:Lida,_Nevada_abandon_house.jpg
    val width: String // 1316
)
