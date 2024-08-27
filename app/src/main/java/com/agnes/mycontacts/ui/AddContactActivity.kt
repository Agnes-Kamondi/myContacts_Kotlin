package com.agnes.mycontacts.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.agnes.mycontacts.R
import com.agnes.mycontacts.databinding.ActivityAddContactBinding
import com.agnes.mycontacts.model.Contact
import com.agnes.mycontacts.viewmodel.ContactsViewModel

class AddContactActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddContactBinding
    val contactsViewModel: ContactsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddContactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
       supportActionBar?.setDisplayHomeAsUpEnabled(true)
       supportActionBar?.setDisplayShowHomeEnabled(true)
       supportActionBar?.setHomeAsUpIndicator(R.drawable.baseline_arrow_back_24)
    }

    override fun onResume() {
        super.onResume()
        binding.btnSave.setOnClickListener { validateContact() }
    }
    fun validateContact() {
        val name = binding.etName.text.toString()
        val phone = binding.etPhoneNumber.text.toString()
        val email = binding.etEmail.text.toString()
        var error = false

        if (name.isBlank()) {
            error = true
            binding.etName.error = (name)
        }
        if(phone.isBlank()){
            error = true
            binding.etPhoneNumber.error =(phone)
        }
        if (email.isBlank()){
            error = true
            binding.etEmail.error = (email)
        }
        if (!error){
            val newContact = Contact(contactId = 0, name=name,email =email, avatar = "", phoneNumber = phone)
            contactsViewModel.saveContact(newContact)
            finish()
        }
        }
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }

}