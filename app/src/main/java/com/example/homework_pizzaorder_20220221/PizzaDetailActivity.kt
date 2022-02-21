package com.example.homework_pizzaorder_20220221

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.normal.TedPermission
import kotlinx.android.synthetic.main.activity_pizza_detail.*

class PizzaDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pizza_detail)


        // 이전화면(PizzaOrderFragment)에서 putExtra로 넘겨준 값받기
        txtName.text =intent.getStringExtra("name")
        txtPhoneNum.text = intent.getStringExtra("phoneNum")

        val star_ratings =intent.getStringExtra("star_ratings")
        txtStar_ratings.text =star_ratings
//        rtbStar_ratings.rating =star_ratings.toFloat()

        
        //Glide 라이브러리 -인터넷 이미지 불러오기
        Glide.with(this).load(intent.getStringExtra("logo")).into(imgLogo)


        // 전화걸기
        btnCallOrder.setOnClickListener {
            val permissionListener = object: PermissionListener{
                override fun onPermissionGranted() {
                    val myUri = Uri.parse("tel:${txtPhoneNum.text}")
                    val myIntent = Intent(Intent.ACTION_CALL, myUri)
                    startActivity(myIntent)
                }
                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                    Toast.makeText(this@PizzaDetailActivity, "권한이 거절되어, 통화가 불가능합니다.", Toast.LENGTH_SHORT).show()
                }
            }
            // 통화관련 실제 권한물어보기
            TedPermission.create()
                .setPermissionListener(permissionListener)
                .setPermissions(Manifest.permission.CALL_PHONE)
                .check()
        }
    }
}