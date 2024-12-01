package racingcar.application

import racingcar.domain.Car

data class Winners(val carNames: List<String>) {
    companion object {
        fun from(cars: List<Car>): Winners {
            val carNames = cars.map { car -> car.name }
            return Winners(carNames)
        }
    }
}
