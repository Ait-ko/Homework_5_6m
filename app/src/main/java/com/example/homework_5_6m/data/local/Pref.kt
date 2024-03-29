package com.example.homework_5_6m.data.local

import android.content.Context

class Pref(private val context: Context) {

    private val pref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    fun saveName(name: String){
        pref.edit().putString(NAME_KEY, name).apply()
    }

    fun getName(): String?{
        return pref.getString(NAME_KEY, "")
    }


    companion object{
        const val PREF_NAME = "pref.name"
        const val NAME_KEY = "name.key"
    }

}