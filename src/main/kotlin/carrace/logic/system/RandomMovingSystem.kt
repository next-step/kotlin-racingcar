package carrace.logic.system

object RandomMovingSystem : MovingSystem {
    private val DICE_RANGE = (0..9)
    private const val DIVIDE_NUMBER = 4

    override fun canMove(): Boolean = DICE_RANGE.random() >= DIVIDE_NUMBER
}
