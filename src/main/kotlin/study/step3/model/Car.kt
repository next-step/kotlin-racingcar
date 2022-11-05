package study.step3.model

class Car {
    private var location: Int = 0
    private var racingTimes: Int = 0
    private var history: MutableMap<Int, Int> = mutableMapOf()

    fun advance(randomDigit: Int) {
        if (randomDigit >= ADVANCE_BASE_DIGIT) {
            location++
        }
        racingTimes++
        history[racingTimes] = location
    }

    fun location(): Int = location
    fun racingTimes(): Int = racingTimes
    fun history(): Map<Int, Int> = history.toMap()

    companion object {
        const val ADVANCE_BASE_DIGIT = 4
    }
}
