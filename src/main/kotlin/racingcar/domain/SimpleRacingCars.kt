package racingcar.domain

import racingcar.domain.strategy.MovingStrategy

@JvmInline
value class SimpleRacingCars(override val value: List<RacingCar>) : RacingCars {
    init {
        require(value.isNotEmpty()) { "한 대 이상의 자동차가 필요합니다." }
    }

    override fun race(): RacingCars = SimpleRacingCars(value.map { it.moved() })

    companion object {
        fun of(count: Int, movingStrategy: MovingStrategy): RacingCars {
            return SimpleRacingCars((1..count).map { SimpleRacingCar(movingStrategy) })
        }

        fun of(count: String?, movingStrategy: MovingStrategy): RacingCars {
            require(!count.isNullOrBlank()) {}
            require(count.toIntOrNull() != null) {}
            return of(count.toInt(), movingStrategy)
        }
    }
}
