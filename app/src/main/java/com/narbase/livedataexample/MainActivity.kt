package com.narbase.livedataexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.arch.lifecycle.ViewModelProviders
import android.arch.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel by lazy { obtainViewModel() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupObservers()
        setupShowRoleButton()
    }

    private fun obtainViewModel() =  ViewModelProviders.of(this).get(RoleViewModel::class.java)

    private fun setupObservers() {
        viewModel.currentRole.observe(this,  Observer { role -> changeRoleText(role) })
    }

    private fun changeRoleText(role: String?) {
        roleTextView.text = role
    }

    private fun setupShowRoleButton() {
        showRoleButton.setOnClickListener {
            val role = viewModel.getRole()
            viewModel.currentRole.postValue(role)
        }
    }
}
