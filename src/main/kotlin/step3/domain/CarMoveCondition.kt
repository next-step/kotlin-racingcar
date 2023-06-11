package step3.domain

class CarMoveCondition(
    private val numberGenerator: NumberGenerator = RandomNumberGenerator()
) : MoveCondition {

    override fun isMovable(): Boolean {
        val number = numberGenerator.generate()
        return number >= FORWARD_CONDITION
    }

    companion object {
        const val FORWARD_CONDITION = 4
    }
}
