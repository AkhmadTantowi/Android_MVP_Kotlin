package com.example.latihanworkshop.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.latihanworkshop.R
import com.example.latihanworkshop.models.User
import kotlinx.android.synthetic.main.list_item_user.view.*

class UserAdapter(var users:List<User>,var context:Context):RecyclerView.Adapter<UserAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item_user,parent,false))
    }

    override fun getItemCount() = users.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(users[position],context)

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        fun bind(user:User,context: Context){
            itemView.user_fullname.text=user.name
            itemView.user_email.text=user.email
        }

    }

}