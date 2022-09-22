package ca.tetervak.dicerollerlab

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class MainViewModel(application: Application): AndroidViewModel(application) {

    private val _liveRollResult = MutableLiveData<Int>()
    val liveRollResult: LiveData<Int> = _liveRollResult

    private val _liveMessage = MutableLiveData<String?>()
    val liveMessage: LiveData<String?> = _liveMessage

    private val diceRolled: String = application.resources.getString(R.string.dice_rolled)

    fun roll() {
        _liveRollResult.value = getRollResult()
        _liveMessage.value = diceRolled
    }

    private fun getRollResult(): Int {
        val dice = Dice(6)
        return dice.roll()
    }

    fun messageIsHandled(){
        _liveMessage.value = null
    }
}