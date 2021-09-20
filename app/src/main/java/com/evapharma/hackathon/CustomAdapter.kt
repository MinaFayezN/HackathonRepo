package com.evapharma.hackathon

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter

class CustomAdapter(context: Context, layoutResource: Int, list: List<Person>) :
    ArrayAdapter<Person>(context, layoutResource, list) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return super.getView(position, convertView, parent)
    }
}