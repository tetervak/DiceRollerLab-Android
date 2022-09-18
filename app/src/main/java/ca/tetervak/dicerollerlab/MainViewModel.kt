package ca.tetervak.dicerollerlab

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class MainViewModel(application: Application): AndroidViewModel(application) {

    private val _rollResult = MutableLiveData<Int>()
    val rollResult: LiveData<Int> = _rollResult

    private val _message = MutableLiveData<String?>()
    val message: LiveData<String?> = _message

    private val diceRolled: String = application.resources.getString(R.string.dice_rolled)

    fun roll() {
        _rollResult.value = getRollResult()
        _message.value = diceRolled
    }

    private fun getRollResult(): Int {
        val dice = Dice(6)
        return dice.roll()
    }

    fun messageIsHandled(){
        _message.value = null
    }
}