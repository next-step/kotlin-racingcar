package step3.domain.car

class Car {

    private var position: Position = Position()

    fun isCurrentPosition(): Position {
        return position
    }

    fun move() {
        position.forward()
    }
}
