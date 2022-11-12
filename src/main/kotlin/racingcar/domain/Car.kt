package racingcar.domain

import java.lang.IllegalArgumentException

class Car(
    var route: Int = 0,
    val name: String = ""
) {
    fun move() {
        this.route += 1
    }

    fun valid() {
        require(name.length < MAX_CAR_NAME_LENGTH) { IllegalArgumentException("차 이름은 5자를 넘으면 안 됩니다.") }
    }

    companion object {
        val MAX_CAR_NAME_LENGTH = 5
        fun generateCar(count: Int) = buildList {
            repeat(count) { add(Car()) }
        }
    }
}
