package com.example.homework_pizzaorder_20220221.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.homework_pizzaorder_20220221.fragments.MyInfoFragment
import com.example.homework_pizzaorder_20220221.fragments.PizzaOrderFragment

class MainViewPagerAdapter(fm:FragmentManager):FragmentPagerAdapter(fm) {

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0-> "피자주문"
            else->"내 정보 설정"
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment {
        if(position==0){
            return PizzaOrderFragment()
        }
        else{
            return MyInfoFragment()
        }
    }


}