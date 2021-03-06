package racingcar.domain

data class Car(val distance: Distance = Distance()) {

    fun move(number: Number): Car {
        if (number.isOver(MOVE_POINT)) {
            return copy(distance = distance.sum(MOVE_DISTANCE))
        }
        return this
    }

    companion object {
        private val MOVE_POINT = Number(4)
        private val MOVE_DISTANCE = Distance(1)
    }
}
