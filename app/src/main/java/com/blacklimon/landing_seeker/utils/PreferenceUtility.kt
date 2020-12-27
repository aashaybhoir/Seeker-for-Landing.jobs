package com.blacklimon.landing_seeker.utils

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import com.blacklimon.landing_seeker.R

class PreferenceUtility {

    companion object{

        fun setString(ctx: Context, key:String, value:String) {

            val preferences = ctx.getSharedPreferences(
                    ctx.getString(R.string.preference_file_key),
                    Context.MODE_PRIVATE)

            with(preferences.edit()){
                putString(key,value)
                apply()
            }
        }

        fun getString(ctx:Context, key:String):String{

            val preferences = ctx.getSharedPreferences(
                    ctx.getString(R.string.preference_file_key),
                    Context.MODE_PRIVATE)

            return preferences.getString(key,"default").toString()
        }

        fun setBoolean(ctx:Context, key:String, value:Boolean){
            val preferences = ctx.getSharedPreferences(
                    ctx.getString(R.string.preference_file_key),
                    Context.MODE_PRIVATE)

            with(preferences.edit()){
                putBoolean(key,value)
                apply()
            }
        }

        fun getBoolean(ctx:Context, key:String):Boolean{

            val preferences = ctx.getSharedPreferences(
                    ctx.getString(R.string.preference_file_key),
                    Context.MODE_PRIVATE)

            return preferences.getBoolean(key,false)
        }
    }

}