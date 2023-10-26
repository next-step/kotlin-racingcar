package game

class AdvanceCountGenerator {
    private val minValue = 0
    private val maxValue = 9

    fun generateRandomValue(): Int {
        return (minValue..maxValue).random()
    }
}
