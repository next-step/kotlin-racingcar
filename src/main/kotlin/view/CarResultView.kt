package view

import model.Car

class CarResultView(private val cars: List<Car>) {
    private val mark = "-"

    fun display() {
        cars.forEach {
            println(mark.repeat(it.getDistance()))
        }
        println()
    }
}
