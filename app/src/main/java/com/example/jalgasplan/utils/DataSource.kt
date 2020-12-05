package com.example.jalgasplan.utils

import com.example.jalgasplan.model.Month

class DataSource {
    companion object{
        fun createDataSet():List<Month>{
            var list = ArrayList<Month>()
            list.add(Month(  "jalgas",
                "You made it to the end of the course!\r\n\r\nNext we'll be building the REST API!",
                "https://raw.githubusercontent.com/mitchtabian/Blog-Images/master/digital_ocean.png"
            )
            )

            return list
        }

    }
}