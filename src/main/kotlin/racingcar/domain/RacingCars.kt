package racingcar.domain

import racingcar.domain.strategy.MovingStrategy

@JvmInline
value class RacingCars(val list: List<RacingCar>) {
    init {
        verify()
    }

    private fun verify() {
        require(list.isNotEmpty()) {
            "한 대 이상의 참가자(경주용 자동차)가 필요합니다."
        }
    }

    fun race() = RacingCars(list.map { it.move() })

    companion object {
        fun of(names: Names, strategy: MovingStrategy): RacingCars {
            return RacingCars(names.list.map { RacingCar(it, strategy) })
        }
    }
}
