package racing.domain

import racing.domain.strategy.MovingStrategy
import java.util.UUID

class Car(
    private val movingStrategy: MovingStrategy
) {

    val carId = UUID.randomUUID()
    var position: Int = 0
        private set

    fun move() {
        if (movingStrategy.isMove()) {
            position += ONE_MOVE_VALUE
        }
    }

    companion object {
        const val ONE_MOVE_VALUE = 1
    }
}
