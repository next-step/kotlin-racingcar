package racingcar.domain

class Car(val userName: String) {
    var position: Int = 0
        private set

    init {
        require(userName.length < UPPER_USERNAME_SIZE) { "자동차 이름은 ${UPPER_USERNAME_SIZE}자를 초과할 수 없습니다." }
    }

    companion object {
        const val UPPER_USERNAME_SIZE = 5
    }

    fun tryMove(conditionNumber: Int) {
        if (CarConfig.MOVE_PERCENTAGE <= conditionNumber) {
            position++
        }
    }
}
