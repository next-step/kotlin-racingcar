package game.racing.domain

class RacingGame(private val racingManager: RacingManager) {
    fun tryMovesRepeatedly(tryNumber: Int): List<List<Car>> {
        val resultList = mutableListOf<List<Car>>()
        repeat(tryNumber) {
            resultList.add(racingManager.moveCars { Car.generateRandomMoveDecision() }.map { it.copy() })
        }
        return resultList
    }
}
