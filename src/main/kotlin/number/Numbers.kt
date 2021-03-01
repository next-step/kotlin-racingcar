package number

object Numbers {
    fun toInt(value: String): Int {
        return value.toIntOrNull() ?: throw IllegalArgumentException("value는 숫자여야 합니다. value : $value")
    }
}
