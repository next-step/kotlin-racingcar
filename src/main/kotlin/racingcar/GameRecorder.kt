package racingcar

import racingcar.model.Car

class GameRecorder {
    val gameResult: GameResult = GameResult()

    fun record(cars: List<Car>) = gameResult.recordTrialResult(TrialResult(cars))
}

data class CarResult(val position: Int)

data class TrialResult(private val trialResult: List<Car>) {
    private val _trialResult: List<CarResult> = trialResult.map { CarResult(it.position) }

    fun get() = _trialResult
}

class GameResult(private val gameResult: MutableList<TrialResult> = mutableListOf()) {
    fun recordTrialResult(trialResult: TrialResult) {
        gameResult.add(trialResult)
    }

    fun get() = gameResult
}
