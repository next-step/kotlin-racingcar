package domain.racing

import util.racing.generator.NumberGenerator

class Game(carAmount: Int, private val trial: Int) {
    private val cars: Cars
    val results: MutableList<Map<Car, String>>

    init {
        validateCarAmount(carAmount)
        validateTrial(trial)
        this.cars = Cars.of(carAmount)
        this.results = mutableListOf()
    }

    fun run(numberGenerator: NumberGenerator) {
        for (it in 1..trial) {
            cars.move(numberGenerator)
            results.add(cars.toResult())
        }
    }

    private fun validateCarAmount(carAmount: Int) {
        if (carAmount < 1) {
            throw IllegalArgumentException("차 갯수는 1개 이상이여야 합니다.")
        }
    }

    private fun validateTrial(trial: Int) {
        if (trial < 1) {
            throw IllegalArgumentException("시도 횟수는 1번 이상이여야 합니다.")
        }
    }
}
