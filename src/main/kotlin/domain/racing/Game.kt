package domain.racing

import util.racing.generator.NumberGenerator

class Game(carAmount: Int, private val trial: Int) {
    private val cars: Cars
    val results: MutableList<Map<Car, String>>

    init {
        this.cars = Cars.of(carAmount)
        this.results = mutableListOf()
    }

    fun run(numberGenerator: NumberGenerator) {
        for (it in 0..trial) {
            cars.move(numberGenerator)
            results.add(cars.toResult())
        }
    }
}
