package study.step3.model

class Car(
    private var location: Int = 0,
    private var racingTimes: Int = 0
) {
    private val history = mutableListOf<Int>()

    fun advance() {
        location++
        saveHistory()
    }

    fun stop() {
        saveHistory()
    }

    private fun saveHistory() {
        racingTimes++
        history.add(location)
    }
    fun getLocation(): Int = location
    fun getRacingTimes(): Int = racingTimes
    fun getHistory(): List<Int> = history.toList()
}
