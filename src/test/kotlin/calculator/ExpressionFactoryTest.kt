package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec

class ExpressionFactoryTest : StringSpec({
    val expressionFactory = ExpressionFactory(
        object : SeparationStrategy {
            override fun separate(input: String): List<String> {
                return input.split(" ")
            }
        }
    )

    "문자열을 입력 받아 `수식(Expression)`을 생성할 수 있다" {
        val parameters = listOf(
            "2 + 3",
            "2 + 3 * 4",
            "2 + 3 * 4 / 2",
            "2 + 3 * 4 / 2 - 10"
        )

        parameters.forEach {
            expressionFactory.create(it)
        }
    }

    "올바르지 않은 문자열 입력 시 예외가 발생한다." {
        val parameters = listOf(
            "2 + 3 /",
            "2+* 4",
            "",
            "   "
        )

        parameters.forEach {
            shouldThrow<java.lang.IllegalArgumentException> {
                expressionFactory.create(it)
            }
        }
    }
})
