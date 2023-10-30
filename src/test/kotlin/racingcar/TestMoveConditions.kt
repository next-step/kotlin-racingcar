package racingcar

class OnlyTrueMoveCondition : MoveCondition {
    override fun canForward(): Boolean {
        return true
    }
}

class OnlyFalseMoveCondition : MoveCondition {
    override fun canForward(): Boolean {
        return false
    }
}
