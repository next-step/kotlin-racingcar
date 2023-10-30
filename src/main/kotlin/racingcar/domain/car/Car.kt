package racingcar.domain.car

class Car(
    val order: Int,
    val name: CarName,
    position: Int = 0,
) {
    var position: Int = position
        private set

    fun move(distance: Int) {
        position += distance
    }

    fun capture(): Car = Car(
        order = order,
        name = name,
        position = position,
    )
}
