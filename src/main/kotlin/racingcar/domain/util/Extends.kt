package racingcar.domain.util

private const val DEFAULT_INT_VALUE = 0

object Extends {

    /**
     * String -> Int 변환
     * */
    fun String.toIntOrDefault(defaultValue: Int = DEFAULT_INT_VALUE): Int {
        return this.toIntOrNull() ?: defaultValue
    }
}
