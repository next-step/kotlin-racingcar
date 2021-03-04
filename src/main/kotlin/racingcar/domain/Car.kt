package racingcar.domain

data class Car(val distance: Distance = Distance()) {

    fun move(number: Number): Car {
        if (number.isOver(MOVE_POINT)) {
            return copy(distance = distance.sum(Distance(1)))
        }
        return this
    }

    companion object {
        val MOVE_POINT = Number(4)
    }
}
