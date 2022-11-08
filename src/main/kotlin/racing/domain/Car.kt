package racing.domain

import racing.domain.strategy.MovingStrategy
import java.util.UUID

class Car(private val movingStrategy: MovingStrategy, private var position: Int = 0) {

    companion object {
        const val POSITION_MARK = "-"
        const val ONE_MOVE_VALUE = 1
    }

    private val carId = UUID.randomUUID()

    fun getPosition(): Int = position

    fun move(): Boolean {
        if (movingStrategy.move()) {
            position += ONE_MOVE_VALUE
            return true
        }
        return false
    }

    fun getPositionMark(): String = POSITION_MARK.repeat(position)
}
