package racingcar.domain

class Car(
    val name: String,
) {
    var position: Int = 0

    fun move() {
        this.position++
    }
}
