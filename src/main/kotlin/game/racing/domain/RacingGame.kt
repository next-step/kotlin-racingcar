package game.racing.domain

class RacingGame(private val racingManager: RacingManager) {
    fun tryMovesRepeatedly(tryNumber: Int): List<List<Car>> {
        val resultList = mutableListOf<List<Car>>()
        repeat(tryNumber) {
            resultList.add(racingManager.moveCars { generateRandomMoveDecision() }.map { it.copy() })
        }
        return resultList
    }

    private fun generateRandomMoveDecision(): Int {
        return (MIN_RANDOM_VALUE..MAX_RANDOM_VALUE).random()
    }

    companion object {
        const val MIN_RANDOM_VALUE = 0
        const val MAX_RANDOM_VALUE = 9
    }
}
