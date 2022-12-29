package domain.racing

import util.racing.generator.NumberGenerator

class Game {
    private val cars: Cars
    private val trial: Int
    val results: MutableList<Map<Car, String>>

    constructor(carAmount: Int, trial: Int) {
        this.cars = Cars.of(carAmount)
        this.trial = trial
        this.results = mutableListOf()
    }

    fun run(numberGenerator: NumberGenerator) {
        for (a in 0..trial) {
            cars.move(numberGenerator)
            results.add(cars.toResult())
        }
    }
}
