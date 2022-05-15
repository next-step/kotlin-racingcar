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
            println("${it.name}: ${mark.repeat(it.distance)}")
        }
    }

    fun whoIsWinner() {
        val result = results.last()

        val maxDistance = result.maxOf { it.distance }
        val winnersName = result.filter { it.distance == maxDistance }
            .map { it.name }

        println("${winnersName.list()}가 최종 우승했습니다.")
    }

    private fun List<String>.list() = this.reduce { first, next -> "$first, $next" }

    data class Record(
        val distance: Int,
        val name: String
    ) {
        constructor(car: Car) : this(car.getDistance(), car.name)
    }
}
