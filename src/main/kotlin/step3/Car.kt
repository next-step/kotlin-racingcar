package step3

class Car(
    val id: Int,
    val name: String,
) {
    var position = Position(value = 0)
        private set
    fun move(oil: Oil) {
        if (this.canMove(oil = oil)) {
            this.position = this.position.forward()
        }
    }

    private fun canMove(oil: Oil): Boolean {
        return oil >= CAN_MOVE_OIL
    }

    companion object {
        private val CAN_MOVE_OIL = Oil(amount = 4)
    }
}
