import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CalculatorTest : StringSpec(
    {
        val sut = Calculator()

        "+는 좌, 우항의 숫자를 더한다." {
            sut.calculate("2 + 3") shouldBe 5
        }

        "-는 좌항에서 우항의 숫자를 뺀다." {
            sut.calculate("5 - 3") shouldBe 2
        }

        "*는 좌항과 우항의 숫자를 곱한다." {
            sut.calculate("2 * 3") shouldBe 6
        }

        "/는 좌항에서 우항의 숫자를 나눈다." {
            sut.calculate("6 / 3") shouldBe 2
        }

        "연산자 순서대로 식을 계산한다." {
            sut.calculate("2 + 3 * 4 / 2") shouldBe 10
        }

        "피연산자의 값이 계산할 수 없는 값이라면 예외를 던진다." {
            shouldThrow<IllegalArgumentException> { sut.calculate("a + b") }
        }

        "존재하지 않는 연산자라면 예외를 던진다." {
            shouldThrow<IllegalArgumentException> { sut.calculate("10 % 2") }
        }

        "연산자와 피연산자의 개수가 맞지 않으면 예외를 던진다." {
            shouldThrow<IllegalArgumentException> { sut.calculate("1 + 2 *") }
        }
    }
)