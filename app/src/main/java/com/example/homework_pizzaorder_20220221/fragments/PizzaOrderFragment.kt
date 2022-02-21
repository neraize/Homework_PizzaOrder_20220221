package com.example.homework_pizzaorder_20220221.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.homework_pizzaorder_20220221.PizzaDetailActivity
import com.example.homework_pizzaorder_20220221.R
import com.example.homework_pizzaorder_20220221.adapters.PizzaAdapter
import com.example.homework_pizzaorder_20220221.datas.PizzaData
import kotlinx.android.synthetic.main.fragment_pizza_order.*

class PizzaOrderFragment:Fragment() {

    val mPizzaList = ArrayList<PizzaData>()
    lateinit var pAdaper: PizzaAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pizza_order, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        // 피자주문 리스트 연결
        mPizzaList.add(PizzaData("https://img1.daumcdn.net/thumb/R800x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2FnkQca%2FbtqwVT4rrZo%2FymhFqW9uRbzrmZTxUU1QC1%2Fimg.jpg", "피자헛","5.0", "1588-5588"))
        mPizzaList.add(PizzaData("https://mblogthumb-phinf.pstatic.net/20160530_65/ppanppane_1464617766007O9b5u_PNG/%C6%C4%C6%C4%C1%B8%BD%BA_%C7%C7%C0%DA_%B7%CE%B0%ED_%284%29.png?type=w800", "파파존스","4.0", "1577-8080"))
        mPizzaList.add(PizzaData("https://pbs.twimg.com/profile_images/1098371010548555776/trCrCTDN_400x400.png", "도미노","4.0", "1577-3082"))
        mPizzaList.add(PizzaData("https://post-phinf.pstatic.net/MjAxODEyMDVfMzYg/MDAxNTQzOTYxOTA4NjM3.8gsStnhxz7eEc9zpt5nmSRZmI-Pzpl4NJvHYU-Dlgmcg.7Vpgk0lopJ5GoTav3CUDqmXi2-_67S5AXD0AGbbR6J4g.JPEG/IMG_1641.jpg?type=w1200", "미스터피자","3.0", "1577-0077"))

        pAdaper = PizzaAdapter(requireContext(),R.layout.pizza_list_item, mPizzaList)

        pizzaListView.adapter = pAdaper


        // 리스트뷰의 각줄이 눌렷을때 대한 이벤트 처리
        pizzaListView.setOnItemClickListener { adapterView, view, position, l -> 
            
            val clickedPizza = mPizzaList[position]
            Toast.makeText(requireContext(), "${clickedPizza.name} 선택하였습니다", Toast.LENGTH_SHORT).show()

            //Intent로 이동 + 데이터 첨부
            val myIntent = Intent(requireContext(), PizzaDetailActivity::class.java)

            myIntent.putExtra("name", clickedPizza.name)
            myIntent.putExtra("logo", clickedPizza.logo)
            myIntent.putExtra("star_ratings", clickedPizza.star_ratings)
            myIntent.putExtra("phoneNum",clickedPizza.phoneNum)

            //Log.d("pizzaOrderFragment",clickedPizza.star_ratings.toString())
            startActivity(myIntent)
        }
    }
}