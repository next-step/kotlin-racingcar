package step2.calculator

object Math {
    fun plus(a: Long, b: Long): Long = a + b

    fun minus(a: Long, b: Long): Long = a - b

    fun multiple(a: Long, b: Long): Long = a * b

    fun divide(a: Long, b: Long): Long = when (b == 0L) {
        true -> throw IllegalArgumentException("유효하지 않은 입력 값입니다.")
        false -> a / b
    }
}
