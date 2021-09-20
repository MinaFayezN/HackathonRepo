package com.evapharma.hackathon

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text


class MainActivity : AppCompatActivity() {

    private val names = mutableListOf("Name01", "Name02", "Name03")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val newAdapter = ArrayAdapter(this@MainActivity, R.layout.spinner_item, names).apply {
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }
        findViewById<Spinner>(R.id.spinner).apply {
            adapter = newAdapter
            onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    adapter: AdapterView<*>?,
                    selectedView: View?,
                    position: Int,
                    id: Long
                ) {
                    val selectedName = (selectedView as TextView).text // names[position]
                    Toast.makeText(this@MainActivity, selectedName, Toast.LENGTH_LONG).show()
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {

                }
            }
        }

        val listView = findViewById<ListView>(R.id.listview)
        listView.adapter = ArrayAdapter.createFromResource(
            this,
            R.array.months,
            android.R.layout.simple_list_item_1
        )
        listView.setOnItemClickListener { adapterView, view, position, id ->
            (view as TextView).text
        }
    }

    private fun scopeFunctions() {
        val name: String = ""
        val isEmptyString: Boolean = name.let {
            it.isEmpty()
        }

        val person = Person("Name 01", "M@M.com")
        person.also {
            it
        }
        val newRes = person.run {
            email = ""
            doSomeOperations("")
        }
        person.apply {
            email = ""

        }
    }
}


data class Person(val name: String, var email: String) {
    fun doSomeOperations(lastName: String): String {
        return lastName

    }
}