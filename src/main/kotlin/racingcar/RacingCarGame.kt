package racingcar

import kotlin.random.Random

class GameResults {
    val gameResult
        get() = _gameResult.toList()
    private val _gameResult = mutableListOf<List<Int>>()

    fun record(carList: List<Car>) {
        val recordData = carList.map { it.position }
        _gameResult.add(recordData)
    }
}

class RacingCarGame(private val carCount: Int, private val trialCount: Int) {
    private val defaultCarGoDecide = {
        val randomValue = Random.nextInt(DEFAULT_RANDOM_RANGE)

        randomValue >= DEFAULT_CAN_GO_THRESHOLD
    }

    private val carList = List(carCount) { Car(defaultCarGoDecide) }

    private val _gameResults = GameResults()
    fun getGameResult() = _gameResults.gameResult

    fun play() = repeat(trialCount) {
        proceed()
        record()
    }

    private fun record() {
        _gameResults.record(carList)
    }

    private fun proceed() = carList.forEach { it.proceed() }

    companion object {
        private const val DEFAULT_CAN_GO_THRESHOLD = 4
        private const val DEFAULT_RANDOM_RANGE = 10
    }
}
