package racingcar.domain

class Car(
    private val carNumber: Int
) {
    private var moveForwardCount: Int = 0

    fun moveForward() = this.moveForwardCount++
    fun getMoveForwardCount() = this.moveForwardCount
}
