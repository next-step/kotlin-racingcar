package calculator

import java.lang.IllegalArgumentException
import kotlin.jvm.Throws

object StringCalculator {

    private val EXPRESSION = """^(\d+\s*[+\-*/]\s*)+\d+$""".toRegex()

    @Throws(IllegalArgumentException::class)
    fun calc(input: String) : Any {
        if (isAvailableInput(input)) throw IllegalArgumentException("유효하지 않은 입력입니다.")

        val split = input.split(" ")
        var acc: Int = -1
        var operator = Operator.ADD
        for (char: String in split) {
            when(val parseResult = parse(char)) {
                is Operator -> operator = parseResult
                is Int -> acc = if(acc == -1) parseResult else operator(acc, parseResult)
                    ?: throw IllegalArgumentException("나누기 연산에서 피연산자 중 0이 존재합니다.")
            }
        }
        return acc
    }
    private fun isAvailableInput(input: String): Boolean = !input.matches(EXPRESSION)
    private fun parse(input: String) = input.toIntOrNull() ?: Operator.of(input)
}
