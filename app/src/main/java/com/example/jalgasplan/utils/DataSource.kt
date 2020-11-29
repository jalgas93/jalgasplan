package com.example.jalgasplan.utils

import com.example.jalgasplan.model.Month

class DataSource {
    companion object{
        fun createDataSet():List<Month>{
            var list = ArrayList<Month>()
            list.add(Month("Yanvar","Fevral","Mart"))
            return list
        }

    }
}