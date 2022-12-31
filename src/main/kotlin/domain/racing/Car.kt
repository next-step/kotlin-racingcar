package domain.racing

class Car(private var position: Position) {

    constructor() : this(Position.create())

    fun move(moveNumber: Int) {
        if (moveNumber >= MIN_MOVE_NUMBER) {
            position.move()
        }
    }

    fun getPosition(): Int {
        return position.position
    }

    companion object {
        private const val MIN_MOVE_NUMBER = 4
    }
}
