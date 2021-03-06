package racingcar.game.domain

const val FORWARD_CRITERIA_NUMBER = 4

const val START_LINE = 0

class Car(val name: String, var position: Int = START_LINE) {
    fun move(condition: Int) {
        if (condition >= FORWARD_CRITERIA_NUMBER) {
            position++
        }
    }
}
