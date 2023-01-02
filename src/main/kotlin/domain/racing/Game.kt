package domain.racing

import util.racing.generator.NumberGenerator

class Game(names: List<Name>, private val trial: Int) {
    private val cars: Cars
    private var _results: MutableList<Map<Car, String>>
    val results: List<Map<Car, String>>
        get() = _results

    init {
        validateNames(names)
        validateTrial(trial)
        this.cars = Cars.of(names)
        this._results = mutableListOf()
    }

    fun run(numberGenerator: NumberGenerator): Winners {
        repeat(trial) {
            cars.move(numberGenerator)
            _results.add(cars.toResult())
        }

        return cars.toWinners()
    }

    fun getWinnerNames(): List<String> {
        return cars.toWinners().winners.map { it.getName() }
    }

    private fun validateNames(names: List<Name>) {
        require(names.isNotEmpty()) { "차 갯수는 1개 이상이여야 합니다." }
    }

    private fun validateTrial(trial: Int) {
        require(trial > 0) { "시도 횟수는 1번 이상이여야 합니다." }
    }
}
