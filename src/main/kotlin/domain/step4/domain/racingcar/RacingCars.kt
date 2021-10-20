package domain.step4.domain.racingcar

import domain.step4.domain.configuration.NumberOfCars
import domain.step4.domain.strategy.MovingStrategy

@JvmInline
value class RacingCars(private val _racingCars: List<RacingCar>) {

    init {
        require(_racingCars.isNotEmpty()) { EMPTY_MESSAGE }
    }

    val racingCars: List<RacingCar>
        get() = _racingCars.toList()

    fun moveForward() = RacingCars(_racingCars.map { it.moveForward() })

    companion object {
        private const val START = 1
        private const val EMPTY_MESSAGE = "비어있는 값은 들어올 수 없습니다."

        fun from(numberOfCars: NumberOfCars, movingStrategy: MovingStrategy) =
            from(numberOfCars.numberOfCars, movingStrategy)

        fun from(numberOfCars: Int, movingStrategy: MovingStrategy) =
            RacingCars((START..numberOfCars).map { RacingCar(movingStrategy = movingStrategy) })
    }
}
