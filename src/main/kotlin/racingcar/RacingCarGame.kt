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

    val gameResults = GameResults()

    fun play() = repeat(trialCount) {
        proceed()
        record()
    }

    private fun record() {
        gameResults.record(carList)
    }

    private fun proceed() = carList.forEach { it.proceed() }

    companion object {
        private const val DEFAULT_CAN_GO_THRESHOLD = 4
        private const val DEFAULT_RANDOM_RANGE = 10

        const val CAR_NUMBER_INPUT_DESC = "자동차 대수는 몇 대인가요?"
        const val TRIAL_NUMBER_INPUT_DESC = "시도할 횟수는 몇 회인가요?"
    }
}
