package racing

import kotlin.random.Random

class RacingCar(private val round: Int) {
    private val distances = Array(round) {0}
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
        return Random.nextInt(0, 10) >= MOVE_PIVOT
    }
}
