package com.evapharma.hackathon

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

private const val HEADER_VIEW_TYPE = 55
private const val USER_VIEW_TYPE = 66
private const val ADMIN_VIEW_TYPE = 77

class UsersAdapter(private val users: MutableList<User>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    fun updateData(newUsers: List<User>){
        users.clear()
        users.addAll(newUsers)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return users.size + 1
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> HEADER_VIEW_TYPE
            else -> {
                if (users[position-1].isAdmin) ADMIN_VIEW_TYPE
                else USER_VIEW_TYPE
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            HEADER_VIEW_TYPE -> {
                val view: View = inflater.inflate(R.layout.header_item, parent, false)
                HeaderViewHolder(view)
            }

            else -> {
                val view: View = inflater.inflate(R.layout.user_item, parent, false)
                UserViewHolder(view).apply {
                    firstName.setOnClickListener {
                        Toast.makeText(it.context, (it as TextView).text, Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is UserViewHolder -> {
                val user: User = users[position-1]
                holder.firstName.text = user.fName
                holder.secondName.text = user.sName
                holder.email.text = user.email
                Glide
                    .with(holder.profile.rootView)
                    .load(user.imageLink)
                    .placeholder(user.imageResource)
                    .into(holder.profile)
                holder.profile.setOnClickListener {
//            user
                }
            }
            is HeaderViewHolder -> {
                holder.title.text = "Header Title"
                holder.icon.setImageResource(R.mipmap.ic_launcher_round)
            }
        }
        /*  To be replaced by Glide
        https://github.com/bumptech/glide
        Glide.loadImage(user.imageLink).into(holder.profile).placeHolder(R.drawable.profile)
         */
    }
}


class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var firstName: TextView = view.findViewById(R.id.tv_firstName)
    var secondName: TextView = view.findViewById(R.id.tv_secondName)
    var email: TextView = view.findViewById(R.id.tv_email)
    var profile: ImageView = view.findViewById(R.id.iv_profile)
}

class HeaderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var title: TextView = view.findViewById(R.id.tv_Titlw)
    var icon: ImageView = view.findViewById(R.id.iv_icon)
}