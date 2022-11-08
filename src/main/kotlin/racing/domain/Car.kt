package racing.domain

import java.util.UUID

class Car(private val movingStrategy: RandomStrategy, private var position: Int = 0) {

    companion object {
        const val POSITION_MARK = "-"
        const val ONE_MOVE_VALUE = 1
    }

    private val carId = UUID.randomUUID()

    fun move() {
        if (movingStrategy.move()) {
            position += ONE_MOVE_VALUE
        }
    }

    fun getPositionMark() = POSITION_MARK.repeat(position)
}
