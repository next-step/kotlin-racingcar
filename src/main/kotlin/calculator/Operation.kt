package calculator

import java.lang.IllegalArgumentException

enum class Operation(
    private val symbol: String,
    val block: (Int, Int) -> Int
) {

    ADD(
        "+",
        { n1, n2 -> n1 + n2 }
    ),
    SUB(
        "-",
        { n1, n2 -> n1 - n2 }
    ),
    MULTI(
        "*",
        { n1, n2 -> n1 * n2 }
    ),
    DIV(
        "/",
        { n1, n2 -> n1 / n2 }
    )
    ;

    companion object {
        fun of(char: String): Operation = values().firstOrNull { it.symbol == char }
            ?: throw IllegalArgumentException("유효하지 않은 연산자 입니다.")
    }
}
