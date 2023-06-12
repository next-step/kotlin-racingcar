package race.model

class FixedMoveCondition(private val canGoStraight: Boolean) : MoveCondition {
    override fun canGoStraight(): Boolean {
        return canGoStraight
    }
}
