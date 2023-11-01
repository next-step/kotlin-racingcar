package racingcar.domain.configuration

import racingcar.domain.car.Car
import racingcar.domain.car.CarGenerator
import racingcar.domain.car.CarName
import racingcar.controller.CarRacingRequest

class CarRacingConfiguration(
    val cars: List<Car>,
    val round: Int,
) {
    companion object {
        fun of(request: CarRacingRequest): CarRacingConfiguration {
            return CarRacingConfiguration(
                cars = setCars(request.carNames),
                round = request.roundCount,
            )
        }

        private fun setCars(carNames: List<CarName>): List<Car> = CarGenerator.create(carNames)
    }
}
