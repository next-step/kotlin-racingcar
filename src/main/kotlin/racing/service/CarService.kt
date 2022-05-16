package racing.service

import racing.controller.dto.RoundResultView
import racing.domain.Car
import racing.domain.CarMovingStepper

class CarService(private val carMovingStepper: CarMovingStepper) {
    fun moveCars(cars: List<Car>, round: Int): List<RoundResultView> {
        val rounds = 1..round
        var racingCars: List<Car> = cars

        return rounds.map { index ->
            racingCars = carMovingStepper.step(racingCars)
            val positions = racingCars.map { it.position }.toList()

            RoundResultView(index, positions)
        }.toList()
    }
}
