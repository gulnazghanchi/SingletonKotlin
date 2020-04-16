package com.appzone.singletonkotlin.model

object Coin{

    private var coin: Int = 0

    fun getCoin():Int{
        return coin
    }

    fun addCoin(){
        coin += 10
    }

    fun deductCoin(){
        coin--
    }
}