package racingcar.domain

enum class MovingJudgeRule(
    private val expression: (Int) -> (Boolean),
    val strategy: MovingStrategy
) {

    ADVANCE_RULE(
        expression = { it >= FORWARD_STRATEGY_BOUND },
        strategy = MovingStrategy.ADVANCE,
    ),
    STOP_RULE(
        expression = { it < FORWARD_STRATEGY_BOUND },
        strategy = MovingStrategy.STOP,
    ),
    ;

    fun judge(number: Int): Boolean {
        return expression(number)
    }

    companion object {
        private const val FORWARD_STRATEGY_BOUND = 4

        fun judge(number: Int): MovingJudgeRule {
            return values()
                .firstOrNull { it.judge(number) } ?: STOP_RULE
        }
    }
}
