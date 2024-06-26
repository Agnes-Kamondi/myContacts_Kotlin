package com.agnes.mycontacts

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.agnes.mycontacts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvContacts.layoutManager = LinearLayoutManager(this)
        displayContacts()
    }
    fun displayContacts(){
        val contact1 = Contact("Anna","0700000000000","anna@gmail.com","")
        val contact2 = Contact("Edward","0700000000001","edward@gmail.com","")
        val contact3 = Contact("Reign","0700000000002","reign@gmail.com","")
        val contact4 = Contact("Duncan","0700000000003","duncan@gmail.com","")
        val contact5 = Contact("Muhadi","0700000000004","muhadi@gmail.com","")
        val contact6 = Contact("Wawire","0700000000005","wawire@gmail.com","")
        val contact7 = Contact("Emily","0700000000006","emily@gmail.com","")
        val contact8 = Contact("Vincent","0700000000007","vincent@gmail.com","")
        val contact9 = Contact("Thomas","0700000000008","thomas@gmail.com","")
        val contact10= Contact("Teresa","0700000000009","teresa@gmail.com","")
        val contact11= Contact("Melissa","0700000000010","melissa@gmail.com","")

        val contactList = listOf(contact1, contact2, contact3, contact4, contact5, contact6, contact7, contact8, contact9,contact10, contact11)
        val contactsAdapter = ContactsAdapter(contactList)
        binding.rvContacts.adapter = contactsAdapter
    }


}
