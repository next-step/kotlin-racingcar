package step3.racingcar.utils

object RandomUtils {
    fun generate(start: Int, end: Int): Int {
        return (start..end).random()
    }
}
