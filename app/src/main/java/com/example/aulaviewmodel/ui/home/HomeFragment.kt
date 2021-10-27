package com.example.aulaviewmodel.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.aulaviewmodel.R
import com.example.aulaviewmodel.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentHomeBinding.inflate(inflater, container, false).apply {
        binding = this
        init()
        setListenners()
        setObservers()
    }.root

    private fun init() {
        viewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

    }

    private fun setObservers(){
        viewModel.action.observe(viewLifecycleOwner){ action ->
            when(action){
                is HomeViewModel.Action.ChangeTextName -> onSetText(action.text)
            }
        }
    }

    private fun setListenners() {
        with(binding){
            homeButtonFirst.setOnClickListener {
                viewModel.onTakeText(homeButtonFirst.text.toString())
            }
            homeButtonSecond.setOnClickListener {
                viewModel.onTakeText(homeButtonSecond.text.toString())
            }
            homeButtonThird.setOnClickListener {
                viewModel.onTakeText(homeButtonThird.text.toString())
            }
        }
    }

    private fun onSetText(text:String){
        binding.homeTextViewText.text = text
    }
}