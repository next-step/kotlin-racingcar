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
        return oil >= CAN_MOVE_OIL
    }

    companion object {
        private val CAN_MOVE_OIL = Oil(amount = 4)
    }
}
