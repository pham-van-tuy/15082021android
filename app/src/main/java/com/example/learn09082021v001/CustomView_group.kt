package com.example.learn09082021v001

import android.content.Context
import android.util.AttributeSet
import android.widget.Button
import android.widget.EditText

import android.widget.LinearLayout
import kotlinx.android.synthetic.main.view_sub_bottom.view.*


class CustomView_group (context: Context, attrs: AttributeSet,) :
    LinearLayout(context, attrs){
    // set fomat layout custom view
    init {
        inflate(context, R.layout.view_sub_bottom, this) // add view to custom view
        val attributes = context.obtainStyledAttributes(attrs, R.styleable.CustomView_group)
        // get value file res >> set propertis
      tvNameClass.text = attributes.getString(R.styleable.CustomView_group_textClass)
        // set propertis from id (attach values file)
        attributes.recycle()
    }
    fun getIncBtn():Button {
        return btnINC
    }
    fun getDecBtn():Button {
        return btnDEC
    }
}
