package racing.service

import racing.controller.dto.CarView
import racing.controller.dto.ResultView
import racing.controller.dto.RoundResultView
import racing.domain.Car
import racing.domain.CarMovingStepper
import racing.domain.extractWinner

class CarService(private val carMovingStepper: CarMovingStepper) {
    fun moveCars(cars: List<Car>, round: Int): ResultView {
        val rounds = 1..round
        val roundResultViews = rounds.map { index ->
            carMovingStepper.step(cars)
            val carsView = cars.map { CarView(it.name, it.position) }.toList()

            RoundResultView(index, carsView)
        }.toList()
        val winners = cars.extractWinner()

        return ResultView(winners, roundResultViews)
    }
}
