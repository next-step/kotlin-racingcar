package calculate

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.WordSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class CalculateTest : WordSpec({
    val sut = Calculate()

    "문자열 입력시 사칙연산 결과를 계산한다" should {
        "덧셈" {
            val actual = sut.calculate("1+2+3+4")
            actual shouldBe 10
        }
        "입력값이 empty 인 경우 예외를 발생한다" {
            listOf("", " ").forAll { a ->
                shouldThrow<IllegalArgumentException> {
                    sut.calculate(a)
                }.message shouldBe "입력값이 empty이면 안됨!"
            }
        }
    }
}
)
