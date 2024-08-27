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
import com.agnes.mycontacts.databinding.ActivityViewContactBinding
import com.agnes.mycontacts.viewmodel.ContactsViewModel

class ViewContactActivity : AppCompatActivity() {
    lateinit var binding : ActivityViewContactBinding
    val contactsViewModel : ContactsViewModel by viewModels()
    var contactId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewContactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(intent.extras!= null){
            contactId = intent.getIntExtra("CONTACT_ID",0)
        }
        else{
            finish()
        }
    }

    override fun onResume() {
        super.onResume()
        contactsViewModel.getContactById(contactId).observe(this){contact ->
            binding.tvContactName.text = contact.name
            binding.tvContactPhone.text = contact.phoneNumber
            binding.tvContactEmail.text = contact.email

        }
    }
}