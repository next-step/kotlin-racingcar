package racingcar.domain

import racingcar.domain.condition.Condition

data class Car(
    var position: Int,
    val carName: CarName,
    private val condition: Condition
) {
    fun move() {
        if (condition.canMove()) {
            position++
        }
    }
}
