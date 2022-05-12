package _3_racing_car.domain

class Engine(private val value: Int) {
    private val minValue = 4

    fun canMoveEngine(): Boolean = value >= minValue
}
