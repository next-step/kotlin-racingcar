package racingcar.model

import java.lang.IllegalArgumentException

data class Car(
    val name: String,
) {
    var position: Int = 0
        private set

    init {
        require(name.length <= 5) { throw IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.") }
    }

    fun move() {
        position++
    }
}
