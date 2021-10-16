package racingcar

class AddCountWhenCallIsForwardRacingCarCondition : RacingCarForwardCondition {

    var count: Int = 0

    override fun isForward(): Boolean {
        count++
        return true
    }
}
