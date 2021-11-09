package racingcar.domain.cars

import racingcar.domain.engine.DefaultEngine
import racingcar.domain.engine.Engine

data class Cars(
    private val engine: Engine = DefaultEngine(),
    private val racingLab: RacingLab = RacingLab(0),
    private val numberOfCars: NumberOfCars
) {
    private val cars: List<Car> = List(numberOfCars.value) {
        Car(
            racingLab = racingLab,
            engine = engine
        )
    }

    val numberOfExistCars: Int
        get() = numberOfCars.value

    val racingLabs: List<Int>
        get() = cars.map { car ->
            car.racingLab()
        }.toList()

    fun race() = cars.forEach { car ->
        car.race()
    }
}
