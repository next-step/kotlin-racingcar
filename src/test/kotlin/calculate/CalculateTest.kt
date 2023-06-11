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
        "뺄셈" {
            val actual = sut.calculate("1-2-3-4")
            actual shouldBe -8
        }
        "곱셈" {
            val actual = sut.calculate("1*2*3*4")
            actual shouldBe 24
        }
        "곱셈 - 0인 값을 곱할때" {
            val actual = sut.calculate("1*2*0*4")
            actual shouldBe 0
        }
        "나눗셈" {
            val actual = sut.calculate("5/2")
            actual shouldBe 2
        }
        "나눗셈 - 0으로 나눌때" {
            shouldThrow<IllegalArgumentException> {
                sut.calculate("5/0") shouldBe 0
            }.message shouldBe "0으로 나눌 수 없습니다."
        }
        "나눗셈 - 대상값이 0일때" {
            val actual = sut.calculate("0/5")
            actual shouldBe 0
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
