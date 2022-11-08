package racingcar.domain

import racingcar.common.RandomNumber

enum class Gear(var range: IntRange) {
    FORWARD(4..9) {
        override fun move(car: Car) {
            car.go()
        }
    },
    STOP(0..3) {
        override fun move(car: Car) {
            car.stop()
        }
    };

    abstract fun move(car: Car)

    companion object {
        private val ran = RandomNumber(0..9)

        fun drive(car: Car) {
            values().find { it.range.contains(ran.generate()) }
                ?.move(car) ?: throw IllegalArgumentException("행동 범위를 벗어남")
        }
    }
}
