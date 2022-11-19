package step3.racingcar.domain

import java.util.UUID

const val CAR_ID_DELIMITER = "-"

class Car {
    val id: String = UUID.randomUUID().toString().substringBefore(CAR_ID_DELIMITER)
    var distance = 0

    fun race(randomNumber: Int) {
        if (isMove(randomNumber)) {
            distance++
        }
    }

    private fun isMove(randomNumber: Int) = randomNumber >= 4
}
