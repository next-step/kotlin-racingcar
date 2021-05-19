package controller

import domain.Cars
import kotlin.math.max

class Winner(val cars: Cars) {

    fun findWinnerNames(): ArrayList<String> {
        val winners = ArrayList<String>()
        var maxScore = 0
        for (car in cars.cars) {
            maxScore = max(car.distance, maxScore)
        }
        for (car in cars.cars) {
            if (maxScore == car.distance) {
                winners.add(car.name)
            }
        }
        return winners
    }
}
