package com.jirawatpoo.oxforddictpicture.main.state

sealed class NetworkState{
    object Loading : NetworkState()
    object Loaded : NetworkState()
    object LoadMore : NetworkState()
    object LoadError : NetworkState()
    data class LoadFail(var error:String) : NetworkState()
}