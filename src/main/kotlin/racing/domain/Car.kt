package racing.domain

import racing.domain.vo.CarMoveResult
import racing.domain.vo.Name
import racing.domain.vo.Position

class Car(private val name: Name, private var position: Position) {
    fun move(movable: Movable): CarMoveResult {
        if (movable.canMove())
            position = position.move()
        return CarMoveResult(name, position)
    }
}
