package com.example.latihanworkshop.presenters

import com.example.latihanworkshop.contracts.MainactifityContract
import com.example.latihanworkshop.models.User
import com.example.latihanworkshop.webservices.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActifityPresenter(v : MainactifityContract.View?) :MainactifityContract.Interactor {
    private var view : MainactifityContract.View? = v
    private var api =ApiClient.instance()
    override fun getAllUser() {
        view?.showLoading()
        api.allUsers().enqueue(object : Callback<List<User>>{
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                view?.hideLoading()
                view?.toast(t.message.toString())
            }

            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if(response.isSuccessful){
                    val  users = response.body()
                    users?.let {
                        view?.attachRecycler(users)
                    }
                }
                view?.hideLoading()
            }

        })
    }

    override fun destroy() {
        view = null
    }
}