package racing

import kotlin.random.Random

class RacingCar(private val round: Int) {
    private val distances = Array(round) {0}
    private val MIN_PIVOT_VALUE = 0
    private val MAX_PIVOT_VALUE = 10
    private val MOVE_PIVOT = 4

    var currentRound = 0

    fun getDistances(): Array<Int> {
        return distances
    }
    fun race() {
        if (canMove()) {
            move()
        }
        currentRound += 1
    }

    private fun move() {
        distances[currentRound] = 1
    }

    private fun canMove(): Boolean {
        return Random.nextInt(MIN_PIVOT_VALUE, MAX_PIVOT_VALUE) >= MOVE_PIVOT
    }
}
