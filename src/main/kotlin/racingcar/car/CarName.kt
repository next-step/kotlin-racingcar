package racingcar.car

import racingcar.exception.RacingCarException

@JvmInline
value class CarName(val name: String) {
    init {
        require(name.length <= 5) { RacingCarException.READ_LINE_IS_EXCEEDED_FIVE_CHAR_EXCEPTION }
    }
}
