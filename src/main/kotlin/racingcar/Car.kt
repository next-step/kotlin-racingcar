package racingcar

class Car(
    private var _location: Int = 0,
) {
    val location
        get() = _location
    fun move(number: Int) {
        val rule = MovingJudgeRule.judge(number)
        val strategy = rule.strategy
        _location = strategy.move(location)
    }
}
