package com.appzone.singletonkotlin

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.appzone.singletonkotlin.model.Coin
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var coin : Coin
    private lateinit var coin1 : Coin

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    private fun initView() {

        coin = Coin
        coin1 = Coin

        btnAddMoreCoin.setOnClickListener(this)
        btnDeductCoin.setOnClickListener(this)
    }

    private fun updateUI(){
        var msg = String.format(Locale.getDefault(), "%d coins left", coin1.getCoin())
        tvCoin.text = msg
    }

    private fun updateLocationCoin(){
        var msg = String.format(Locale.getDefault(), "Coin Location : %d ", coin.hashCode())
        tvCoinLocation.text = msg
    }

    private fun updateLocation1Coin(){
        var msg = String.format(Locale.getDefault(), "Coin Location : %d ", coin1.hashCode())
        tvCoin1Location.text = msg
    }

    override fun onResume() {
        super.onResume()
        updateUI()
        updateLocationCoin()
        updateLocation1Coin()
    }

    override fun onClick(view: View?) {
        when (view!!.id) {
            R.id.btnAddMoreCoin -> {
                coin.addCoin()
                updateUI()
                updateLocationCoin()
                updateLocation1Coin()
            }
            R.id.btnDeductCoin -> {
                startActivity(Intent(this, DeductCoinActivity::class.java))
            }
        }
    }

}
