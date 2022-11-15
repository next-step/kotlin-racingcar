package step3

class OilPolicy(
    private val oil: Oil,
) : MovePolicy {
    override fun canMove(): Boolean {
        return oil >= CAN_MOVE_OIL
    }

    companion object {
        private val CAN_MOVE_OIL = Oil(amount = 4)
    }
}
