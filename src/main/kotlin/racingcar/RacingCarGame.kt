package racingcar

import kotlin.random.Random

class GameResults {
    val gameResult
        get() = _gameResult.toList()
    private val _gameResult = mutableListOf<List<String>>()

    fun record(carList: List<Car>) {
        val recordData = carList.map { it.makeResult() }
        _gameResult.add(recordData)
    }
}

class RacingCarGame(private val trialCount: Int, carCount: List<String>) {
    private val defaultCarGoDecide = {
        val randomValue = Random.nextInt(DEFAULT_RANDOM_RANGE)

        randomValue >= DEFAULT_CAN_GO_THRESHOLD
    }

    private val carList = List(carCount.size) { Car(carCount[it], defaultCarGoDecide) }

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

        const val CAR_NAMES_INPUT_DESC = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
        const val TRIAL_NUMBER_INPUT_DESC = "시도할 횟수는 몇 회인가요?"
    }
}
