package racingcar

class OnlyTrueMoveCondition : MoveCondition {
    override fun canForward(): Boolean {
        return true
    }
}

class OnlyFirstConditionTrueMoveCondition : MoveCondition {
    private var condition = true
    override fun canForward(): Boolean {
        val originCondition = condition
        condition = false

        return originCondition
    }
}
