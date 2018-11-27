package com.jirawatpoo.oxforddictpicture.main.state

sealed class NetworkState{
    object Loading : NetworkState()
    object Loaded : NetworkState()
    object LoadMore : NetworkState()
    object LoadError : NetworkState()
    data class LoadFail(var error:String) : NetworkState()
}

enum class Network(val value:Int,val error: String){
    Loaded(0,""),
    Loading(1,""),
    Loaderror(2,"error")
}

sealed class NetworkLoad(val value: Int,val error:String){
    data class Loaded(val defaultValue: Int = 0) : NetworkLoad(defaultValue,"")
    data class Loading(val defaultValue: Int = 1) : NetworkLoad(defaultValue,"")
    data class LoadError(val errorValue:String, val defaultValue: Int = 0) : NetworkLoad(defaultValue,errorValue)
}