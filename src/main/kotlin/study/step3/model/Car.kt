package study.step3.model

class Car {
    private var location: Int = 0
    private var racingTimes = 0

    fun advance(randomDigit: Int) {
        if (randomDigit >= ADVANCE_BASE_DIGIT) {
            location++
        }
        racingTimes++
    }

    fun location(): Int = location
    fun racingTimes(): Int = racingTimes

    companion object {
        const val ADVANCE_BASE_DIGIT = 4
    }
}
