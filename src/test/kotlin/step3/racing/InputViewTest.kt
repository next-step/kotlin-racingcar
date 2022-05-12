package step3.racing

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class InputViewTest : DescribeSpec({
  describe("getLong") {
    it("정수형이 입력되면 그 값을 반환한다.") {
      val input = 5

      val result = InputView.getLong(input)

      result shouldBe input
    }

    it("정수형이 아니면 IllegalArgumentException 을 던진다") {
      val input = 5.4

      val exception = shouldThrow<IllegalArgumentException> {
        InputView.getLong(input)
      }

      exception.message shouldBe "유효하지 않은 입력 값입니다."
    }

    it("null 이 입력되면 IllegalArgumentException 을 던진다") {
      val input = null

      val exception = shouldThrow<IllegalArgumentException> {
        InputView.getLong(input)
      }

      exception.message shouldBe "유효하지 않은 입력 값입니다."
    }

    it("빈 문자열이 입력되면 IllegalArgumentException 을 던진다") {
      val input = ""

      val exception = shouldThrow<IllegalArgumentException> {
        InputView.getLong(input)
      }

      exception.message shouldBe "유효하지 않은 입력 값입니다."
    }

    it("\r 이 입력되면 IllegalArgumentException 을 던진다") {
      val input = "\r"

      val exception = shouldThrow<IllegalArgumentException> {
        InputView.getLong(input)
      }

      exception.message shouldBe "유효하지 않은 입력 값입니다."
    }

    it("\n 이 입력되면 IllegalArgumentException 을 던진다") {
      val input = "\n"

      val exception = shouldThrow<IllegalArgumentException> {
        InputView.getLong(input)
      }

      exception.message shouldBe "유효하지 않은 입력 값입니다."
    }

    it("\r\n 이 입력되면 IllegalArgumentException 을 던진다") {
      val input = "\r\n"

      val exception = shouldThrow<IllegalArgumentException> {
        InputView.getLong(input)
      }

      exception.message shouldBe "유효하지 않은 입력 값입니다."
    }
  }
})
