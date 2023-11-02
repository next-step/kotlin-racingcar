package racingcar.domain.car

class Car(
    val name: CarName,
    position: Int = 0,
) {
    var position: Int = position
        private set

    fun move(distance: Int) {
        position += distance
    }

    fun isWin(other: Car): Boolean = position > other.position

    fun isDraw(other: Car): Boolean = position == other.position
}
