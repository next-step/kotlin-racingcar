package racingcar

import kotlin.random.Random

class RacingCarGame(private val carCount: Int, private val trialCount: Int) {
    private val defaultCarGoDecide = {
        val randomValue = Random.nextInt(DEFAULT_RANDOM_RANGE)

        randomValue >= DEFAULT_CAN_GO_THRESHOLD
    }

    private val carList = List(carCount) { Car(defaultCarGoDecide) }

    val gameResult
        get() = _gameResult.toList()
    private val _gameResult = mutableListOf<List<Int>>()

    fun play() = repeat(trialCount) {
        proceed()
        record()
    }

    private fun record() {
        val recordData = carList.map { it.position }
        _gameResult.add(recordData)
    }

    private fun proceed() = carList.forEach { it.proceed() }

    companion object {
        private const val DEFAULT_CAN_GO_THRESHOLD = 4
        private const val DEFAULT_RANDOM_RANGE = 10
    }
}
