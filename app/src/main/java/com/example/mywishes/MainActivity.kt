package com.example.mywishes

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    lateinit var wishes: ArrayList<Wish>
    //method to hide the keyboard
    fun hideKeyBoard(){
        this.currentFocus?.let { view ->
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
            imm?.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var itemName = findViewById<EditText>(R.id.ItemNameTextView)
        var Price = findViewById<EditText>(R.id.PriceTextView)
        var Link = findViewById<EditText>(R.id.ItemLinkTextView)
        val submitButton = findViewById<Button>(R.id.submit)

        wishes = ArrayList()
        submitButton.setOnClickListener(){
            wishes.add(Wish(itemName.text.toString(),Price.text.toString(), Link.text.toString()))
            itemName.setText("")
            Price.setText("")
            Link.setText("")
            hideKeyBoard()
        }

        // ...
        // Lookup the recyclerview in activity layout
        val recyclerView = findViewById<View>(R.id.recyclerView1) as RecyclerView
        // Create adapter passing in the sample user data
        val adapter = WishesAdapter(wishes)
        // Attach the adapter to the recyclerview to populate items
        recyclerView.adapter = adapter
        // Set layout manager to position the items
       recyclerView.layoutManager = LinearLayoutManager(this)

    }

}