package racingcar.domain

import racingcar.domain.strategy.MovingStrategy

@JvmInline
value class RacingCars(val values: List<RacingCar>) {
    init {
        verify()
    }

    private fun verify() {
        require(values.isNotEmpty()) {
            "한 대 이상의 참가자(경주용 자동차)가 필요합니다."
        }
    }

    fun race() = RacingCars(values.map { it.move() })

    companion object {
        fun of(names: Names, strategy: MovingStrategy): RacingCars {
            return RacingCars(names.values.map { RacingCar(it, strategy) })
        }
    }
}
