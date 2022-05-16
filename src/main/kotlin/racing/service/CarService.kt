package racing.service

import racing.controller.dto.CarView
import racing.controller.dto.ResultView
import racing.controller.dto.RoundResultView
import racing.domain.Car
import racing.domain.CarMovingStepper

class CarService(private val carMovingStepper: CarMovingStepper) {
    fun moveCars(cars: List<Car>, round: Int): ResultView {
        val rounds = 1..round
        val roundResultViews = rounds.map { index ->
            carMovingStepper.step(cars)
            val carsView = cars.map { CarView(it.name, it.position) }.toList()

            RoundResultView(index, carsView)
        }.toList()
        val winners = extractWinner(cars)

        return ResultView(winners, roundResultViews)
    }

    fun extractWinner(cars: List<Car>): List<String> {
        val sortedCars = cars.sortedBy { it.position }
        val longestPosition = sortedCars.last().position

        return sortedCars.filter { it.position == longestPosition }
            .map { it.name }
            .toList()
    }
}
