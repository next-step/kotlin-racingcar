package racing.domain

class Car(
    val carName: CarName,
    var position: Position = Position(value = 0)
) {

    fun move() {
        position.move()
    }
}
