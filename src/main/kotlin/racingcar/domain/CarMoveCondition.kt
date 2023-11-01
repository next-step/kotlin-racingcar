package racingcar.domain

class CarMoveCondition(
    private val number: () -> Int,
) : MoveCondition {
    override fun canForward(): Boolean {
        return number() >= MinimumValue
    }

    companion object {
        private const val MinimumValue = 4
    }
}
