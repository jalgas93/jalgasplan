package com.example.jalgasplan.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "jalgas")
data class Contact (
    @PrimaryKey(autoGenerate = true)
     @ColumnInfo(name = "id")
    var id:Int,
    @ColumnInfo(name="sideName")
    val sideName:String,
    @ColumnInfo(name="name")
    val name:String

): Serializable