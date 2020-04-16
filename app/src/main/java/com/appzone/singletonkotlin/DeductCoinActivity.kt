package com.appzone.singletonkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.appzone.singletonkotlin.model.Coin
import kotlinx.android.synthetic.main.activity_deduct_coin.*
import java.util.*

class DeductCoinActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var coin : Coin

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deduct_coin)

        initView()
    }

    private fun initView() {

        coin = Coin

        btnDeduct.setOnClickListener(this)
    }

    private fun updateUI(){
        var msg = String.format(Locale.getDefault(), "%d coins left", coin.getCoin())
        tvCoinDeduct.text = msg
    }

    override fun onClick(view: View?) {
        when (view!!.id) {
            R.id.btnDeduct -> {
                coin.deductCoin()
                updateUI()
            }
        }
    }
}
