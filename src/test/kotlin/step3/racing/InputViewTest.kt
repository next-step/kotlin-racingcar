package step3.racing

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class InputViewTest : DescribeSpec({
  describe("getInt()") {
    it("정수형이 입력되면 그 값을 반환한다.") {
      val input = "5"

      val result = InputView.getInt(input)

      result shouldBe 5
    }

    it("정수형이 아니면 IllegalArgumentException 을 던진다") {
      val input = "5.4"

      val exception = shouldThrow<IllegalArgumentException> {
        InputView.getInt(input)
      }

      exception.message shouldBe "숫자가 입력되지 않았습니다."
    }

    it("null 이 입력되면 IllegalArgumentException 을 던진다") {
      val input = null

      val exception = shouldThrow<IllegalArgumentException> {
        InputView.getInt(input)
      }

      exception.message shouldBe "입력 값이 없습니다."
    }

    it("빈 문자열이 입력되면 IllegalArgumentException 을 던진다") {
      val input = ""

      val exception = shouldThrow<IllegalArgumentException> {
        InputView.getInt(input)
      }

      exception.message shouldBe "입력 값이 없습니다."
    }

    it("\r 이 입력되면 IllegalArgumentException 을 던진다") {
      val input = "\r"

      val exception = shouldThrow<IllegalArgumentException> {
        InputView.getInt(input)
      }

      exception.message shouldBe "입력 값이 없습니다."
    }

    it("\n 이 입력되면 IllegalArgumentException 을 던진다") {
      val input = "\n"

      val exception = shouldThrow<IllegalArgumentException> {
        InputView.getInt(input)
      }

      exception.message shouldBe "입력 값이 없습니다."
    }

    it("\r\n 이 입력되면 IllegalArgumentException 을 던진다") {
      val input = "\r\n"

      val exception = shouldThrow<IllegalArgumentException> {
        InputView.getInt(input)
      }

      exception.message shouldBe "입력 값이 없습니다."
    }
  }

  describe("getStringArray") {
    it("문자열을 콤마 단위로 분할하여 배열을 반환한다.") {
      val input = "a,b,c"

      val result: List<String> = InputView.getStringArray(input)

      result shouldBe listOf("a", "b", "c")
    }

    it("문자 하나를 입력받으면 길이 1 배열을 반환한다.") {
      val input = "a"

      val result: List<String> = InputView.getStringArray(input)

      result shouldBe listOf("a")
    }

    it("빈 문자열을 입력받으면 빈 배열을 반환한다.") {
      val input = ""

      val exception = shouldThrow<IllegalArgumentException> {
        InputView.getStringArray(input)
      }

      exception.message shouldBe "입력 값이 없습니다."
    }

    it("null을 입력받으면 IllegalArgumentException 을 던진다") {
      val input = null

      val exception = shouldThrow<IllegalArgumentException> {
        InputView.getStringArray(input)
      }

      exception.message shouldBe "입력 값이 없습니다."
    }
  }
})
