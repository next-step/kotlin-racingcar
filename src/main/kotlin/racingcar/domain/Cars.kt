package racingcar.domain

import racingcar.domain.Car.Companion.BLANK_NAME
import racingcar.strategy.NumberGeneratorStrategy

class Cars(carNames: CarNames, carCount: PositiveNumber) {
    private val _cars: List<Car> = carNames.map { Car(it) }
    private val cars: List<Car>
        get() = _cars.toList()

    fun count(): Int {
        return cars.size
    }

    fun move(strategy: NumberGeneratorStrategy): Scores {
        val scores =
            cars.map {
                it.move(strategy)
                Score(it)
            }
        return Scores(scores)
    }
}

fun Cars(carCount: PositiveNumber): Cars {
    return Cars(CarNames(Array(carCount.number) { CarName(BLANK_NAME) }.toList()), carCount)
}

fun Cars(carNames: CarNames): Cars {
    return Cars(carNames, PositiveNumber(carNames.count().toString()))
}
