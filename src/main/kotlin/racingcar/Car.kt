package racingcar

class Car(
    private var _location: Int = 0,
    val name: String,
) {
    init {
        require(isValidLength(name)) { "글자수는 5자를 넘을 수 없어요" }
    }

    val location
        get() = _location
    fun move(number: Int) {
        val rule = MovingJudgeRule.judge(number)
        val strategy = rule.strategy
        _location = strategy.move(_location)
    }

    private fun isValidLength(name: String): Boolean {
        return name.length <= VALID_CAR_NAME_LENGTH
    }

    companion object {
        private const val VALID_CAR_NAME_LENGTH = 5
    }
}
