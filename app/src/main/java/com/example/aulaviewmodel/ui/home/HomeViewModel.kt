package com.example.aulaviewmodel.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {


    internal sealed class Action{
        data class ChangeTextName(val text: String) :Action()
        object goToNotification : Action()
    }

    internal val action = MutableLiveData<Action>()


    fun onTakeText(text: String){
        action.postValue(Action.ChangeTextName(text))
    }

    fun directToNotification(){
        action.postValue(Action.goToNotification)
    }
}