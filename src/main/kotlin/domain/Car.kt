package domain

import util.RandomNumber

class Car(
    val name: String,
    private val randomNumber: RandomNumber
) {

    var position: Int = 0
        private set

    init {
        require(name.length < CAR_NAME_MAX_LENGTH) { throw IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.") }
    }

    fun move(number: Int = randomNumber.getRandomNumber()) {
        if (isMoving(number)) position++
    }

    private fun isMoving(number: Int): Boolean = number >= FORWARD_CONDITION_NUMBER

    companion object {
        const val CAR_NAME_MAX_LENGTH = 5
        const val FORWARD_CONDITION_NUMBER = 4
    }
}
