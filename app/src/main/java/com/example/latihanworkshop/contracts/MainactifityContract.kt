package com.example.latihanworkshop.contracts

import com.example.latihanworkshop.models.User
import java.security.MessageDigest

interface MainactifityContract {

    interface View {
        fun attachRecycler(users : List<User>)
        fun showLoading()
        fun hideLoading()
        fun toast(messageDigest: String)
    }
    interface Interactor {
        fun getAllUser()
        fun destroy()
    }


}