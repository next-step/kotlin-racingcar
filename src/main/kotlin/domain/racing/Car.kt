package domain.racing

class Car(private val name: Name, private var position: Position) {

    constructor(name: Name) : this(name, Position.create())

    fun move(moveNumber: Int) {
        if (moveNumber >= MIN_MOVE_NUMBER) {
            position = position.move()
        }
    }

    fun getPosition(): Int {
        return position.position
    }

    fun getName(): String {
        return name.name
    }

    companion object {
        private const val MIN_MOVE_NUMBER = 4
    }
}
