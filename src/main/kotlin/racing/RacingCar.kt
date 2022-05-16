package racing

class RacingCar(private val round: Int, val name: String) {
    companion object {
        const val MOVE_PIVOT = 4
        const val MOVE = 1
        const val NEXT_ROUND = 1
    }

    private val _distances = MutableList(round) { 0 }
    val distances: MutableList<Int>
        get() = this._distances

    private var currentRound = 0

    fun race(movePoint: Int) {
        if (canMove(movePoint)) {
            move()
        }
        currentRound += NEXT_ROUND
    }

    private fun move() {
        _distances[currentRound] = MOVE
    }

    private fun canMove(movePoint: Int): Boolean {
        return movePoint >= MOVE_PIVOT
    }
}
