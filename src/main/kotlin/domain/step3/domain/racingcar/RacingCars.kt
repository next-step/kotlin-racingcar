package domain.step3.domain.racingcar

import domain.step3.domain.configuration.NumberOfAttempts
import domain.step3.domain.strategy.MovingStrategy

@JvmInline
value class RacingCars(private val racingCars: List<RacingCar>) {
    fun moveForward() = RacingCars(racingCars.map { it.moveForward() })

    companion object {
        const val START = 1

        fun from(numberOfAttempts: NumberOfAttempts, movingStrategy: MovingStrategy) =
            from(numberOfAttempts.numberOfAttempts, movingStrategy)

        fun from(numberOfAttempts: Int, movingStrategy: MovingStrategy) =
            RacingCars((START..numberOfAttempts).map { RacingCar(movingStrategy = movingStrategy) })
    }
}
