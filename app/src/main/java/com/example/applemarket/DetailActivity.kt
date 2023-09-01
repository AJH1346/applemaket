package com.example.applemarket

import android.content.Intent
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.example.applemarket.databinding.ActivityMainBinding


class DetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        // 뭐가 문젠지 모르겠는데 binding이 안돼서 findviewById를 사용
        val product = intent.getParcelableExtra<Product>("product")
        if (product != null) {
            // 상세 페이지 UI 설정
            findViewById<TextView>(R.id.textProductName).text = product.name
            findViewById<TextView>(R.id.textProductAddress).text = product.address
            findViewById<TextView>(R.id.textProductPrice).text = product.price
            findViewById<TextView>(R.id.textProductContent).text = product.content
            findViewById<TextView>(R.id.UserName).text = product.username
            findViewById<ImageView>(R.id.imageProduct).setImageResource(product.image)
        }


        val backbutton = findViewById<ImageButton>(R.id.backbutton)

        backbutton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        //밑줄 긋기
        val manner = findViewById<TextView>(R.id.mannertext)
        manner.paintFlags = Paint.UNDERLINE_TEXT_FLAG



    }

}