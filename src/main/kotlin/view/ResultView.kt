package view

import model.Car

class ResultView {
    private val results = mutableListOf<List<Record>>()
    private val mark = "-"

    fun record(cars: List<Car>) {
        results.add(cars.map { Record(it) })
    }

    fun showResult() {
        results.forEach {
            display(it)
            println()
        }
    }

    private fun display(result: List<Record>) {
        result.forEach {
            println(mark.repeat(it.distance))
        }
    }

    data class Record(
        val distance: Int,
        val names: String
    ) {
        constructor(car: Car) : this(car.getDistance(), car.name)
    }
}
