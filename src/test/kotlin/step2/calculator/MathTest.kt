package step2.calculator

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class MathTest : DescribeSpec({
  describe("덧셈") {
    it("5 + 3 = 8") {
      // given
      // when
      val result = Math.plus(5, 3)

      // then
      result shouldBe 8
    }
  }

  describe("뺄셈") {
    it("5 - 3 = 2") {
      // given
      // when
      val result = Math.minus(5, 3)

      // then
      result shouldBe 2
    }
  }

  describe("곱셈") {
    it("5 * 3 = 15") {
      // given
      // when
      val result = Math.multiple(5, 3)

      // then
      result shouldBe 15
    }
  }

  describe("나눗셈") {
    it("6 / 3 = 2") {
      // given
      // when
      val result = Math.divide(6, 3)

      // then
      result shouldBe 2
    }
  }

})
