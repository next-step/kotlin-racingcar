package racingcar.game.domain

const val FORWARD_CRITERIA_NUMBER = 4
const val START_LINE = 0
const val MAX_CAR_NAME = 5

class Car(val name: String, var position: Int = START_LINE) {

    init {
        require(name.isNotBlank()) { "자동차 이름은 null 혹은 blank 값이 될 수 없습니다." }
        require(name.length <= MAX_CAR_NAME) { "자동차 이름은 5자를 초과할 수 없습니다." }
    }

    fun move(condition: Int) {
        if (condition >= FORWARD_CRITERIA_NUMBER) {
            position++
        }
    }
}
