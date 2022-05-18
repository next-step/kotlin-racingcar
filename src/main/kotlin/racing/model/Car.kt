package racing.model

import racing.Movable

class Car(private val name: Name, private var position: Position) {
    fun move(movable: Movable): CarMoveResult {
        if (movable.canMove())
            position = position.move()
        return CarMoveResult(name, position)
    }
}
