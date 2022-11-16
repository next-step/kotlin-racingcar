package stringcalculator.domain

enum class Calculator(private val sign: String) {

    ADD("+");

    companion object {
        fun of(sign: String): Calculator {
            values().find { it.sign == sign }
                ?.let { return it }
                .run { throw IllegalArgumentException("연산할 수 없는 기호입니다. 기호: $sign") }
        }
    }
}
