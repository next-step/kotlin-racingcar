package racingcar.domain

class Car(
    val id: Int
) {
    var position: Int = 0

    fun move() {
        this.position++
    }
}
