package step3.racingcar.domain

import step3.racingcar.domain.condition.Condition

data class Car(
    var position: Int,
    var condition: Condition
) {
    fun move() {
        if (condition.canMove()) {
            position++
        }
    }
}
