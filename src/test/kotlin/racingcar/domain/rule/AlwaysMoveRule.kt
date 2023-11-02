package racingcar.domain.rule

class AlwaysMoveRule(private val distance: Int = 1) : MoveRule {
    override fun determineMoveDistance(): Int = distance
}
