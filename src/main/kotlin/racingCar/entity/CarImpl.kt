package racingCar.entity

class CarImpl(override val name: String, override val distance: Int = 1) : Car {
    override fun move(randNumber: Int): Car {
        if (randNumber < MOVE_BASE_POINT) return CarImpl(this.name, this.distance)
        return CarImpl(this.name, this.distance + 1)
    }

    companion object {
        const val MOVE_BASE_POINT = 4
        const val MOVE_START_POINT = 0
        const val MOVE_END_POINT = 9
    }
}
