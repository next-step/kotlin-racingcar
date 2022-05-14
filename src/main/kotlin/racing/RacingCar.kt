package racing

import kotlin.random.Random

class RacingCar(private val round: Int) {
    private val distances = Array(round) {0}
    var currentRound = 0

    fun getDistances(): Array<Int> {
        return distances
    }

    fun tryMove() {
        if (canMove()) {
            move()
        }
        currentRound += 1
    }

    private fun move() {
        distances[currentRound] = 1
    }

    private fun canMove(): Boolean {
        return Random.nextInt(0, 10) >= 4
    }
}
