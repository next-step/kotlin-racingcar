package racingcar.domain.racing

import racingcar.domain.car.Car

class Winners(private val winners: List<Car>) : List<Car> by winners {

    constructor(carsHistory: CarsHistory) : this(carsHistory.maxDrivenCars)
}
