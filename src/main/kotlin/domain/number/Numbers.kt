package domain.number

object Numbers {
    private const val START_INDEX = 0

    fun toInt(value: String): Int {
        return value.toIntOrNull() ?: throw IllegalArgumentException("value는 숫자여야 합니다. value : $value")
    }
}
