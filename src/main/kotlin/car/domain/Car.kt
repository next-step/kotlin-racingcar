package car.domain

import car.domain.vo.Name
import car.domain.vo.Position

class Car(
    val name: Name,
    position: Position
): Comparable<Car> {
    var position: Position = position
        private set

    fun move(movingStrategy: MovingStrategy) {
        if (movingStrategy.movable()) {
            position = position.increase()
        }
    }

    override fun compareTo(other: Car): Int = position.value - other.position.value
}
