package step3.racingcar.domain

import java.util.*

private const val CAR_ID_DELIMITER = "-"
private const val MOVE_CRITERIA = 4

class Car {
    val id: String = UUID.randomUUID().toString().substringBefore(CAR_ID_DELIMITER)
    var distance = 0

    fun race(randomNumber: Int) {
        if (isMove(randomNumber)) {
            distance++
        }
    }

    private fun isMove(randomNumber: Int): Boolean = randomNumber >= MOVE_CRITERIA
}
