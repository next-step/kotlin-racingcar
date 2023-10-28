package racingcar.domain

class Car(
    val order: Int,
    position: Int = 0,
) {
    var position: Int = position
        private set

    fun move(distance: Int) {
        position += distance
    }
}
