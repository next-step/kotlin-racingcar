package racingCar.model

import racingCar.constants.Message

/**
 * 차량의 데이터를 저장하는 데이터 클래스
 * Created by Jaesungchi on 2022.05.07..
 */
class Car(val name: String) {
    init {
        checkValidName(name)
    }

    var position: Int = INIT_POSITION
        private set

    fun advanceOnce() {
        position++
    }

    private fun checkValidName(name: String) {
        if (name.isBlank()) {
            throw IllegalArgumentException(Message.ExceptionMessage.CANNOT_NAME_BE_BLANK)
        }
        if (name.length > MAX_NAME_SIZE) {
            throw IllegalArgumentException(Message.ExceptionMessage.CANNOT_NAME_EXCEED_5_CHARACTERS)
        }
    }

    companion object {
        private const val INIT_POSITION = 0
        private const val MAX_NAME_SIZE = 5
    }
}
