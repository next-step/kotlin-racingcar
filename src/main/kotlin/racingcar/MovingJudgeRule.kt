package racingcar

enum class MovingJudgeRule(
    private val expression: (Int) -> (Boolean),
    private val strategy: MovingStrategy
) {

    ADVANCE_RULE(
        expression = { number -> number >= FORWARD_STRATEGY_BOUND },
        strategy = MovingStrategy.ADVANCE,
    ),
    STOP_RULE(
        expression = { false },
        strategy = MovingStrategy.STOP,
    ),
    ;

    fun judge(number: Int): Boolean {
        return expression(number)
    }

    fun strategy(): MovingStrategy {
        return strategy
    }

    companion object {
        private const val FORWARD_STRATEGY_BOUND = 4

        fun judge(number: Int): MovingJudgeRule {
            return values()
                .firstOrNull { it.judge(number) } ?: STOP_RULE
        }
    }
}
