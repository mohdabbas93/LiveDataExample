package com.narbase.livedataexample

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import java.util.*

class RoleViewModel: ViewModel() {

    private val wereWolfRole: List<String> = listOf(
            "Mason",
            "Seer",
            "Villager",
            "Tanner",
            "Hunter",
            "Werewolf"
    )
    var currentRole = MutableLiveData<String>()

    fun getRole(): String {
        val random = Random()
        val randIndex = random.nextInt(wereWolfRole.size)
        return wereWolfRole[randIndex]
    }

}