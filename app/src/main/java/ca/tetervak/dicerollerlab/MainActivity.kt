package ca.tetervak.dicerollerlab

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import ca.tetervak.dicerollerlab.databinding.ActivityMainBinding

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {

    companion object {
        const val TAG = "MainActivity"
    }

    private lateinit var binding: ActivityMainBinding

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rollButton.setOnClickListener { mainViewModel.roll() }

        mainViewModel.rollResult.observe(this) { result ->
            updateOutputs(result)
        }
    }

    /**
     * Update the screen showing the result.
     */
    private fun updateOutputs(rollResult: Int) {
        displayToastMessage()
        Log.d(TAG, "onDiceRoll: rollResult = $rollResult")
        updateTextOutput(rollResult)
        updateDiceImage(rollResult)
    }

    private fun updateTextOutput(rollResult: Int) {
        binding.resultTextView.text = rollResult.toString()
    }

    private fun displayToastMessage() {
        val toast = Toast.makeText(this, getString(R.string.dice_rolled), Toast.LENGTH_SHORT)
        toast.show()
    }

    private fun updateDiceImage(diceRoll: Int) {
        with(binding.imageView) {
            when (diceRoll) {
                1 -> setImageResource(R.drawable.dice_1)
                2 -> setImageResource(R.drawable.dice_2)
                3 -> setImageResource(R.drawable.dice_3)
                4 -> setImageResource(R.drawable.dice_4)
                5 -> setImageResource(R.drawable.dice_5)
                6 -> setImageResource(R.drawable.dice_6)
            }
        }

    }
}