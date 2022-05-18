package racing

object RandomMoving : Movable {
    private const val MIN_MOVABLE_VALUE = 4

    override fun canMove(): Boolean {
        return RandomGenerator.generate() >= MIN_MOVABLE_VALUE
    }
}
