package racingcar.application

import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.domain.Name

class RacingGame : RacingGameUseCase {

    override fun createCars(carNameList: List<String>): Cars {
        val carList = carNameList.map { Car(name = Name(it)) }
        return Cars(carList)
    }

    override fun run(cars: Cars) {
        cars.move()
    }

    override fun getWinners(cars: Cars): List<String> {
        return cars.getWinners().map { it.name.name }
    }
}
