package step2

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldContainExactly

class ExpressionTokenizerTest : FunSpec({
    val sut = ExpressionTokenizer

    context("tokenize 메서드는") {
        context("계산식을 입력하면") {
            test("연산자/피연산자를 여러개의 토큰으로 토큰화할 수 있다.") {
                // given
                val expression = "2 + 3 - 5"
                // when
                val actual = sut.tokenize(expression = expression)
                // then
                val expected = listOf(
                    Token.from(value = "2"),
                    Token.from(value = "+"), Token.from(value = "3"),
                    Token.from(value = "-"), Token.from(value = "5"),
                )
                actual shouldContainExactly expected
            }
        }
    }
})
