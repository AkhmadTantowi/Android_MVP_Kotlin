package com.example.latihanworkshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.latihanworkshop.adapters.UserAdapter
import com.example.latihanworkshop.contracts.MainactifityContract
import com.example.latihanworkshop.models.User
import com.example.latihanworkshop.presenters.MainActifityPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainactifityContract.View {
    override fun attachRecycler(users: List<User>) {
        rv_main.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = UserAdapter(users, this@MainActivity)
        }
    }

    override fun showLoading() {
        loading_bar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        loading_bar.visibility = View.GONE
    }

    override fun toast(messageDigest: String) {
        Toast.makeText(this@MainActivity, messageDigest, Toast.LENGTH_LONG).show()
    }

    private var presenter = MainActifityPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.getAllUser()
    }
}
