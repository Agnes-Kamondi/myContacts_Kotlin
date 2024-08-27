package com.agnes.mycontacts.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.agnes.mycontacts.databinding.ActivityMainBinding
import com.agnes.mycontacts.model.Contact
import com.agnes.mycontacts.viewmodel.ContactsViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val contactsViewModel : ContactsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvContacts.layoutManager = LinearLayoutManager(this)
//        displayContacts()
    }
    override fun onResume(){
        super.onResume()
        binding.fabAddContact.setOnClickListener { startActivity(Intent(this,AddContactActivity::class.java)) }
        contactsViewModel.getAllContacts().observe(this){
            contactsList ->
                displayContacts(contactsList)
        }
    }
    fun displayContacts(contactsList: List<Contact>) {

        val contactsAdapter = ContactsAdapter(contactsList,this)
        binding.rvContacts.adapter = contactsAdapter
    }


}
