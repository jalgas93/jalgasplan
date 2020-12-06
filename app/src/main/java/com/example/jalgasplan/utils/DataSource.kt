package com.example.jalgasplan.utils

import com.example.jalgasplan.model.Model

class DataSource {
    companion object{
        fun createDataSet():ArrayList<Model>{
            var list = ArrayList<Model>()
            list.add(
                Model(  "jalgas",
                "You made it to the end of the course!\r\n\r\nNext we'll be building the REST API!",
                "https://raw.githubusercontent.com/mitchtabian/Blog-Images/master/digital_ocean.png",
                    "jalgas"
            )
            )
            list.add( Model(  "jalgas",
                "You made it to the end of the course!\r\n\r\nNext we'll be building the REST API!",
                "https://raw.githubusercontent.com/mitchtabian/Blog-Images/master/digital_ocean.png",
                "jalgas"
            ))

            return list
        }

    }
}