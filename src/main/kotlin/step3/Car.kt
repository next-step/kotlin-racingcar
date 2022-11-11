package step3

class Car {
    var position = 0
        private set
    fun move(oil: Oil) {
        if (canMove(oil = oil)) {
            this.position++
        }
    }

    private fun canMove(oil: Oil): Boolean {
        return oil.amount >= CAN_MOVE_FUEL
    }

    companion object {
        private const val CAN_MOVE_FUEL = 4
    }
}
