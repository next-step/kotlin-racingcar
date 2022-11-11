package step3

class Car {
    var position = 0
        private set
    fun move(fuel: Int) {
        if (canMove(fuel = fuel)) {
            this.position++
        }
    }

    private fun canMove(fuel: Int): Boolean {
        return fuel >= CAN_MOVE_FUEL
    }

    companion object {
        private const val CAN_MOVE_FUEL = 4
    }
}
