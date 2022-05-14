package racingcar

import racingcar.model.Car

class GameRecorder {
    val gameResult: GameResult = GameResult()

    fun record(cars: List<Car>) = gameResult.recordTrialResult(TrialResult(cars.map { CarResult(it) }))
}

data class CarResult(val name: String, val position: Int) {
    constructor(car: Car) : this(car.name, car.position)
}

data class TrialResult(private val trialResult: List<CarResult>) {
    val winners: List<String> = trialResult
        .groupBy { it.position }
        .maxByOrNull { (position, _) -> position }!!
        .value
        .map { it.name }

    fun get() = trialResult
}

class GameResult {
    private val gameResult: MutableList<TrialResult> = mutableListOf()

    val winners: List<String>
        get() = gameResult.last().winners

    fun recordTrialResult(trialResult: TrialResult) {
        gameResult.add(trialResult)
    }

    fun get() = gameResult
}
