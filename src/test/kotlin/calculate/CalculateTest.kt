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
        "입력값이 empty 인 경우 예외를 발생한다" {
            listOf("", " ").forAll { a ->
                shouldThrow<IllegalArgumentException> {
                    sut.calculate(a)
                }.message shouldBe "입력값이 empty이면 안됨!"
            }
        }
        "대상값중 공백이 포함되어 있거나, 2개이상의 연상자가 포함되어 있을 때 예외가 발생한다." {
            listOf("1+2-3* 4", "1+ 2-3* 4", "1+2-3**4").forAll { a ->
                shouldThrow<IllegalArgumentException> {
                    sut.calculate(a)
                }.message shouldBe "연산자는 한번에 1개만 가능합니다"
            }
        }
        "사칙연산 기호가 아닌 경우 예외가 발생한다." {
            listOf("1+2-3^4", "1+2-3?4", "1!3?4").forAll { a ->
                shouldThrow<IllegalArgumentException> {
                    sut.calculate(a)
                }.message shouldBe "지원하지 않는 연산자입니다."
            }
        }
    }
}
)
