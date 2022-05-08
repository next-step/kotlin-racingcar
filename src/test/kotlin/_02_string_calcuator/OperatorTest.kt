package _02_string_calcuator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class OperatorTest : AnnotationSpec() {
    @ParameterizedTest
    @MethodSource("calculations")
    fun `덧셈에 대한 사칙연산을 수행한다`(operator: Operator, left: Int, right: Int, expected: Int) {
        val result = operator.calculate(left, right)

        result shouldBe expected
    }

    @Test
    fun `나눗셈에 대한 오른쪽 연산자가 0인 경우 에러를 발생한다`() {
        val result = shouldThrow<IllegalArgumentException> { Operator.DIVIDE.calculate(4, 0) }

        result.message shouldBe "나눗셈의 분모 값은 0이 될 수 없다."
    }

    @ParameterizedTest
    @MethodSource("operators")
    fun `사칙연산 기호에 대한 enum class를 반환한다`(symbol: String, operator: Operator) {
        val result = Operator.find(symbol)

        result shouldBe operator
    }

    @Test
    fun `사칙연산 기호가 아닌 경우 에러를 발생한다`() {
        val result = shouldThrow<IllegalArgumentException> { Operator.find("~") }

        result.message shouldBe "사칙연산 기호가 아니다."
    }

    companion object {
        @JvmStatic
        fun calculations(): Stream<Arguments> = Stream.of(
            Arguments.of(Operator.PLUS, 4, 2, 6),
            Arguments.of(Operator.MINUS, 4, 2, 2),
            Arguments.of(Operator.MULTIPLY, 4, 2, 8),
            Arguments.of(Operator.DIVIDE, 4, 2, 2),
        )

        @JvmStatic
        fun operators(): Stream<Arguments> = Stream.of(
            Arguments.of("+", Operator.PLUS),
            Arguments.of("-", Operator.MINUS),
            Arguments.of("*", Operator.MULTIPLY),
            Arguments.of("/", Operator.DIVIDE),
        )
    }
}
