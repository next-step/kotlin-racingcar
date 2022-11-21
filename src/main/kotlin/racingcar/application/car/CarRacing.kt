package racingcar.application.car

import racingcar.domain.car.Car
import racingcar.domain.car.CarFactory
import racingcar.domain.car.CarName
import racingcar.domain.car.CarRacingResult
import racingcar.view.PromptServiceImpl

class CarRacing(
    private val promptService: PromptServiceImpl
) {
    fun run() {
        val cars = CarFactory.create(promptService.getNameOfCars())
        val moves = promptService.getNumberOfMoves()

        val result = startRace(cars, moves)

        promptService.showResult(result)
    }

    companion object {
        fun startRace(cars: List<Car>, moves: Int): List<CarRacingResult> {
            return List(moves) {
                val distances = mutableMapOf<CarName, Int>()

                cars.forEach {
                    distances[it.name] = it.move()
                }
                distances
            }
        }
    }
}
