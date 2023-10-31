package racingcar.domain.rule

class AlwaysMoveRule(val distance: Int = 1) : MoveRule {
    override fun determineMoveDistance(): Int = distance
}
