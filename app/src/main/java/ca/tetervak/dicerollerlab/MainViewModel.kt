package ca.tetervak.dicerollerlab

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private val _rollResult = MutableLiveData<Int>()
    val rollResult: LiveData<Int> = _rollResult

    fun roll() {
        _rollResult.value = getRollResult()
    }

    private fun getRollResult(): Int {
        val dice = Dice(6)
        return dice.roll()
    }
}