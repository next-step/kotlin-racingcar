package racingcar.domain

class Car(
    var position: Int = 0,
    val movable: () -> Boolean,
) {
    fun move(): Int {
        if (movable.invoke()) {
            return ++position
        }
        return position
    }
}
