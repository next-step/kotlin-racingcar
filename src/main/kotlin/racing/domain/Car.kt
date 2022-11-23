package racing.domain

class Car(
    val carName: CarName,
    var position: Position = Position()
) {

    fun move() {
        position.move()
    }
}
