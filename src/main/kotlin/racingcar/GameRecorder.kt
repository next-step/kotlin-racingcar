package racingcar

import racingcar.model.Car

class GameRecorder {
    val gameResult: GameResult = GameResult()

    fun record(cars: List<Car>) = gameResult.recordTrialResult(TrialResult(cars.map { CarResult(it) }))
}

data class CarResult(val position: Int) {
    constructor(car: Car) : this(car.position)
}

data class TrialResult(private val trialResult: List<CarResult>) {
    fun get() = trialResult
}

class GameResult {
    private val gameResult: MutableList<TrialResult> = mutableListOf()

    fun recordTrialResult(trialResult: TrialResult) {
        gameResult.add(trialResult)
    }

    fun get() = gameResult
}
