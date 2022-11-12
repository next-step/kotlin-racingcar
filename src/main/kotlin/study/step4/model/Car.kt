package study.step4.model

import study.step4.util.DigitEngine
import study.step4.util.EnginGenerator
import study.step4.util.RandomDigit

class Car(
    val name: String = "",
    private var location: Int = 0,
    private var racingTimes: Int = 0,
    private val engin: EnginGenerator = DigitEngine(RandomDigit())
) {
    private val history = mutableListOf<Int>()

    fun move() {
        if (engin.run()) {
            advance()
        }

        saveHistory()
    }

    private fun advance() {
        location++
    }

    private fun saveHistory() {
        racingTimes++
        history.add(location)
    }

    fun getLocation(): Int = location
    fun getRacingTimes(): Int = racingTimes
    fun getHistory(): List<Int> = history.toList()
}
