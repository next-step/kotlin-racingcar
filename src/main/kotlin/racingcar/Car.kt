package racingcar

import java.lang.IllegalArgumentException
import kotlin.random.Random

private const val START = 0
private const val FORWARD = 4
private const val LIMIT = 10

private const val MOVE_POS = 1

class Car(
    val pos: Int = 0
) {

    fun race(rnd: Random): Car {
        return when (rnd.nextInt(LIMIT)) {
            in START until FORWARD -> Car(pos)
            in FORWARD until LIMIT -> Car(pos + MOVE_POS)
            else -> throw IllegalArgumentException("System error")
        }
    }
}
