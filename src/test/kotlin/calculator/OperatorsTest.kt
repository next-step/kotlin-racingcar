package calculator

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

internal class OperatorsTest : StringSpec({
    "연산을 수행하는 기능" {
        // given
        val numbers = listOf(1, 2, 3)
        val operators = Operators(listOf(Operator.PLUS, Operator.MULTIPLY))

        // when
        val actual = operators.operate(numbers.toMutableList())

        // then
        actual shouldBe 9
    }
})
