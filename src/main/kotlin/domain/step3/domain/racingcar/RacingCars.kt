package domain.step3.domain.racingcar

import domain.step3.domain.configuration.NumberOfCars
import domain.step3.domain.strategy.MovingStrategy

@JvmInline
value class RacingCars(private val racingCars: List<RacingCar>) {
    fun moveForward() = RacingCars(racingCars.map { it.moveForward() })

    companion object {
        private const val START = 1

        fun from(numberOfCars: NumberOfCars, movingStrategy: MovingStrategy) =
            from(numberOfCars.numberOfCars, movingStrategy)

        fun from(numberOfCars: Int, movingStrategy: MovingStrategy) =
            RacingCars((START..numberOfCars).map { RacingCar(movingStrategy = movingStrategy) })
    }
}
