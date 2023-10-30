package racingcar.domain.rule

class AlwaysStopRule() : MoveRule {
    override fun determineMoveDistance(): Int = 0
}
