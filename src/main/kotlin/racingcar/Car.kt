package racingcar

import racingcar.RacingCarEngine.FORWARD
import racingcar.RacingCarEngine.NON_FORWARD

private const val MOVE_POS = 1

class Car(
    val pos: Int = 0,
) {

    fun race(engine: RacingCarEngine): Car {
        return when (engine) {
            FORWARD -> Car(pos + MOVE_POS)
            NON_FORWARD -> this
        }
    }
}
