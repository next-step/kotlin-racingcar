package controller

import domain.Cars
import kotlin.math.max

class Winner(val cars: Cars) {

    fun findWinnerNames(): List<String> {
        val winners = ArrayList<String>()
        var maxScore = 0
        for (car in cars.cars) {
            maxScore = max(car.distance, maxScore)
        }
        return cars.cars.filter { it.distance == maxScore }.map { it.name }

    }
}
