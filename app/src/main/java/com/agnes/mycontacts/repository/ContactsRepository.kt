package com.agnes.mycontacts.repository

import androidx.lifecycle.LiveData
import com.agnes.mycontacts.ContactsApp
import com.agnes.mycontacts.database.ContactsDatabase
import com.agnes.mycontacts.model.Contact
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ContactsRepository {
    val database = ContactsDatabase.getDatabase(ContactsApp.appContext)

    suspend fun saveContact(contact: Contact){
        withContext(Dispatchers.IO){
            database.getContactDao().insertContact(contact)
        }
    }
    fun getAllContacts(): LiveData<List<Contact>>{
        return database.getContactDao().getAllContacts()
    }
    fun getContactById(contactId: Int): LiveData<Contact>{
        return database.getContactDao().getContactById(contactId)
    }

}