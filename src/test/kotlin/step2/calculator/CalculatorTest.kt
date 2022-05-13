package step2.calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class CalculatorTest : DescribeSpec({
  it("올바른 문자열이 입력되었을 때 정삭적으로 결과를 응답한다.") {
    forAll(
      row("8 + 4", 12),
      row("8 - 4", 4),
      row("8 * 4", 32),
      row("8 / 4", 2)
    ) { input, expectResult ->
      val result = Calculator().execute(input)

      result shouldBe expectResult
    }

    forAll(
      row("8 + 4 + 2", 14),
      row("8 - 4 - 2", 2),
      row("8 * 4 * 2", 64),
      row("8 / 4 / 2", 1)
    ) { input, expectResult ->
      val result = Calculator().execute(input)

      result shouldBe expectResult
    }

    forAll(
      row("8 + 4 - 2", 10),
      row("8 - 4 * 2", 8),
      row("8 * 4 / 2", 16),
      row("8 / 4 + 2", 4)
    ) { input, expectResult ->
      val calculator = Calculator()

      val result = calculator.execute(input)

      result shouldBe expectResult
    }
  }

  describe("올바르지 않은 문자열이 입력되었을 경우") {
    it("사칙연산 기호가 아닌 경우 IllegalArgumentException 을 던진다.") {
      val input = "4 & 2"
      val calculator = Calculator()

      val exception = shouldThrow<IllegalArgumentException> {
        calculator.execute(input)
      }

      exception.message shouldBe "유효하지 않은 입력 값입니다."
    }

    it("띄어쓰기가 한칸씩이 아닐 경우 IllegalArgumentException 을 던진다.") {
      val input = "4 +  2"
      val calculator = Calculator()

      val exception = shouldThrow<IllegalArgumentException> {
        calculator.execute(input)
      }

      exception.message shouldBe "유효하지 않은 입력 값입니다."
    }
  }
})
