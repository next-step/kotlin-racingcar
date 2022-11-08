package step2

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class ChunkTokenCalculatorTest : FunSpec({
    val sut = ChunkTokenCalculator()

    context("calculate 메서드는") {
        context("여러 개의 연산자/피연산자 토큰을 입력하면") {
            test("계산한 결과를 숫자로 반환한다.") {
                // given
                val tokens = listOf(
                    Token.of(value = "2"),
                    Token.of(value = "+"), Token.of(value = "3"),
                    Token.of(value = "*"), Token.of(value = "4"),
                    Token.of(value = "/"), Token.of(value = "2"),
                )
                // when
                val actual = sut.calculate(tokens = tokens)
                // then
                actual shouldBe 10
            }
        }
    }
})
