package racingcar.domain

import racingcar.domain.Car
import racingcar.domain.Cars

class Statistics() {
    companion object {
        fun exec(cars: Cars): List<Car> {
            var max = cars.findMaxStatusValue()
            return cars.statistic(max)
        }
    }
}
