package racingcar.domain

import racingcar.domain.strategy.MovingStrategy
import racingcar.domain.vo.Position

@JvmInline
value class RacingCars(private val value: List<RacingCar>) {
    init {
        require(value.isNotEmpty()) { "한 대 이상의 자동차가 필요합니다." }
    }

    fun race(): RacingCars = RacingCars(value.map { it.moved() })

    fun toList(): List<RacingCar> = value.toList()

    fun withPositionsOf(position: Position) = RacingCars(value.filter { it.position == position })

    companion object {
        fun of(input: String?, movingStrategy: MovingStrategy): RacingCars {
            require(!input.isNullOrBlank()) {}
            val names = input.split(DEFAULT_SEPARATOR).map { it.trim() }
            return of(names, movingStrategy)
        }

        private fun of(names: List<String>, movingStrategy: MovingStrategy): RacingCars {
            return RacingCars(names.map { RacingCar(it, movingStrategy) })
        }

        private const val DEFAULT_SEPARATOR = ","
    }
}
