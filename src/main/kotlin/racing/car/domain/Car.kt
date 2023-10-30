package racing.car.domain

abstract class Car(
    var position: Int,
) {
    abstract fun move(input: Int)
    abstract fun isMovable(input: Int): Boolean
}
