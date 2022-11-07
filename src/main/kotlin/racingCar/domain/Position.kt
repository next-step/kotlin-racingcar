package racingCar.domain

data class Position(val position: Int = 1) {
    fun increase(): Position = Position(position + 1)
}
