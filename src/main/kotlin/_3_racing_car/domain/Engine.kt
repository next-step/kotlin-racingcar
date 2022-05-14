package _3_racing_car.domain

class Engine() {

    fun canMoveEngine(value: Int): Boolean = value >= MIN_VALUE

    companion object {
        private const val MIN_VALUE = 4
    }
}
