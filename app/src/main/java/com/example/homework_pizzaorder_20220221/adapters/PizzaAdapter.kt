package com.example.homework_pizzaorder_20220221.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.homework_pizzaorder_20220221.R
import com.example.homework_pizzaorder_20220221.datas.PizzaData

class PizzaAdapter(
    val mContext:Context,
    val resId:Int,
    val mList:ArrayList<PizzaData>

):ArrayAdapter<PizzaData>(mContext, resId, mList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var tempRow =convertView
        if(tempRow==null){
            tempRow= LayoutInflater.from(mContext).inflate(R.layout.pizza_list_item, null)
        }
        val row =tempRow!!

        //실제 데이터 반영
        val data=mList[position]
        val imgLogo = row.findViewById<ImageView>(R.id.imgLogo)
        val txtName = row.findViewById<TextView>(R.id.txtName)
        val rtbStar_ratings = row.findViewById<RatingBar>(R.id.rtbStar_ratings)

        //Glide 라이브러리 -인터넷 이미지 불러오기
        Glide.with(imgLogo).load(data.logo).into(imgLogo)

        //imgLogo.text = data.name
        txtName.text = data.name
        rtbStar_ratings.rating = data.star_ratings.toFloat()

        return row
    }
}