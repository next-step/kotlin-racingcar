package racing.service

import racing.controller.dto.RoundResultView
import racing.domain.Car
import racing.domain.MovingRule

class CarService(private val movingRule: MovingRule) {
    fun moveCars(cars: List<Car>, round: Int): List<RoundResultView> {
        val roundResultViews: MutableList<RoundResultView> = mutableListOf()

        for (i in 1..round) {
            val movingCar = movingRule.goForward(cars)
            val positions = movingCar.map {
                it.position
            }.toList()

            roundResultViews.add(RoundResultView(i, positions))
        }
        return roundResultViews
    }
}
