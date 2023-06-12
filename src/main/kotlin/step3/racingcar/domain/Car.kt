package step3.racingcar.domain

import step3.racingcar.domain.condition.Condition

class Car(
    var position: Int,
    private val condition: Condition
) {
    fun move() {
        if (condition.canMove()) {
            position++
        }
    }
}
