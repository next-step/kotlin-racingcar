package racing

class RacingCar(private val round: Int) {
    companion object {
        const val MOVE_PIVOT = 4
        const val MOVE = 1
        const val NEXT_ROUND = 1
    }

    private val distances = MutableList(round) {0}
    private var currentRound = 0

    fun getDistances(): MutableList<Int> {
        return distances
    }

    fun race(movePoint: Int) {
        if (canMove(movePoint)) {
            move()
        }
        currentRound += NEXT_ROUND
    }

    private fun move() {
        distances[currentRound] = MOVE
    }

    private fun canMove(movePoint: Int): Boolean {
        return movePoint >= MOVE_PIVOT
    }
}
