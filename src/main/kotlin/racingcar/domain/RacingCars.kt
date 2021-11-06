package racingcar.domain

import racingcar.domain.strategy.MovingStrategy

@JvmInline
value class RacingCars(private val value: List<RacingCar>) {
    init {
        require(value.isNotEmpty()) { "한 대 이상의 자동차가 필요합니다." }
    }

    fun race(): RacingCars = RacingCars(value.map { it.moved() })

    fun toList(): List<RacingCar> = value.toList()

    companion object {
        fun of(count: Int, movingStrategy: MovingStrategy): RacingCars {
            return RacingCars((1..count).map { RacingCar(movingStrategy) })
        }

        fun of(count: String?, movingStrategy: MovingStrategy): RacingCars {
            require(!count.isNullOrBlank()) {}
            require(count.toIntOrNull() != null) {}
            return of(count.toInt(), movingStrategy)
        }
    }
}
