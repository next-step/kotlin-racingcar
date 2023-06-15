package racingcar.domain

import racingcar.domain.condition.Condition

class Car(
    var position: Int,
    val carName: CarName,
    private val condition: Condition
) {
    fun move() {
        if (condition.canMove()) {
            position++
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Car

        return carName == other.carName
    }

    override fun hashCode(): Int {
        return carName.hashCode()
    }
}
