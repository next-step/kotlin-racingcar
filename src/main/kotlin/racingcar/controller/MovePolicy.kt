package racingcar.controller

object MovePolicy {
    private const val THRESHOLD = 4

    fun decide(condition: Int): Int {
        return if (condition < THRESHOLD) 0 else 1
    }
}
