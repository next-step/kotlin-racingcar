package car_race.logic.car

import car_race.logic.system.MovingSystem

data class CarPosition(
    private var value: Int = 0
) {
    fun getValue() = value

    fun nextRound() {
        val randomNum = MovingSystem.rollDice()

        value += if (randomNum >= DIVIDE_NUMBER) 1 else 0
    }

    companion object {
        private const val DIVIDE_NUMBER = 4
    }
}
