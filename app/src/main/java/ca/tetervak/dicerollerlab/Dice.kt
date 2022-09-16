package ca.tetervak.dicerollerlab

class Dice(val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}
