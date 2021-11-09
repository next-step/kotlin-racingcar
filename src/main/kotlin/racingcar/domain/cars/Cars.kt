package racingcar.domain.cars

import racingcar.domain.engine.DefaultEngine
import racingcar.domain.engine.Engine

data class Cars(
    private val engine: Engine = DefaultEngine(),
    private val startPosition: Position = Position(0),
    private val numberOfCars: NumberOfCars
) {
    private val cars: List<Car> = List(numberOfCars.value) {
        Car(
            position = startPosition,
            engine = engine
        )
    }

    val numberOfExistCars: Int
        get() = numberOfCars.value

    val carsCurrentPosition: List<Int>
        get() = cars.map { car ->
            car.currentPosition()
        }.toList()

    fun race() = cars.forEach { car ->
        car.race()
    }
}
