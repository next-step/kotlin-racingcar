package game.racing.domain

class RacingGame(private val racingManager: RacingManager) {
    fun tryMovesRepeatedly(tryNumber: Int): List<List<Car>> {
        val resultList = mutableListOf<List<Car>>()
        repeat(tryNumber) {
            resultList.add(racingManager.moveCars { MovementStrategy.randomMoveStrategy() }.map { it.copy() })
        }
        return resultList
    }

    companion object {
        const val MIN_RANDOM_VALUE = 0
        const val MAX_RANDOM_VALUE = 9
    }
}
