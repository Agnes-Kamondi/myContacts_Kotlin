package com.agnes.mycontacts.ui

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.agnes.mycontacts.databinding.ContactListItemBinding
import com.agnes.mycontacts.model.Contact

class ContactsAdapter(var contactsList: List<Contact>, val context: Context):
    RecyclerView.Adapter<ContactsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {
        var binding = ContactListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ContactsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {
        val contact = contactsList[position]
        holder.binding.tvName.text = contact.name
        holder.binding.tvPhoneNumber.text = contact.phoneNumber
        holder.binding.tvEmail.text = contact.email
        holder.binding.cvContact.setOnClickListener{
            val intent = Intent(context, ViewContactActivity::class.java)
            intent.putExtra("CONTACT_ID", contact.contactId)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return contactsList.size
    }
}
class ContactsViewHolder(var binding : ContactListItemBinding):
    RecyclerView.ViewHolder(binding.root)



//class ContactsAdapter(var contactsList: List<Contact>):
//    RecyclerView.Adapter<ContactsViewHolder>() {
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {
//       var itemView = LayoutInflater.from(parent.context).inflate(R.layout.contact_list_item, parent,false)
//        return ContactsViewHolder(itemView)
//    }
//
//    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {
//        val contact = contactsList[position]
//        holder.tvName.text = contact.name
//        holder.tvPhoneNumber.text = contact.phoneNumber
//        holder.tvEmail.text = contact.email
//    }
//
//    override fun getItemCount(): Int {
//        return contactsList.size
//    }
//}
//class ContactsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
//    val tvName = itemView.findViewById<TextView>(R.id.tvName)
//    val tvPhoneNumber = itemView.findViewById<TextView>(R.id.tvPhoneNumber)
//    val tvEmail = itemView.findViewById<TextView>(R.id.tvEmail)
//}