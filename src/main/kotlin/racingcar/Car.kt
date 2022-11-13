package racingcar

class Car(
    private var location: Int = 0,
) {
    fun move(randNumber: Int) {
        val rule = MovingJudgeRule.judge(randNumber)
        val strategy = rule.strategy()

        location = strategy.move(location)
    }

    fun currentLocation(): Int {
        return location
    }
}
