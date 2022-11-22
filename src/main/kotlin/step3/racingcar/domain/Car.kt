package step3.racingcar.domain

import java.util.*

private const val CAR_ID_DELIMITER = "-"
private const val MOVE_CRITERIA = 4

class Car {
    val id: String = UUID.randomUUID().toString().substringBefore(CAR_ID_DELIMITER)
    private var randomNumbers: RandomNumbers = RandomNumbers()
    var distance = 0

    fun addRandomNumber(randomNumber: Int) = randomNumbers.add(randomNumber)

    fun race(currentRoundIndex: Int) {
        val randomNumberByCurrentRound: Int = randomNumbers[currentRoundIndex]
        if (isMove(randomNumberByCurrentRound)) {
            distance++
        }
    }

    private fun isMove(randomNumber: Int): Boolean = randomNumber >= MOVE_CRITERIA
}
