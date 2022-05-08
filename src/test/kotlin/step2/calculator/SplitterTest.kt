package step2.calculator

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class SplitterTest : DescribeSpec({

  describe("덧셈 문자열 분리") {
    it("덧셈 이항식일 경우 숫자와 연산자를 분리한다.") {
      // given
      val expression = "3 + 4"

      // when
      val splitter = Splitter(expression)

      // then
      splitter.left shouldBe 3
      splitter.right shouldBe 4
      splitter.operator shouldBe Operator.PLUS
      splitter.hasOther shouldBe false
    }

    it("덧셈 삼항식일 경우 숫자, 연산자, 나머지 식을 분리한다.") {
      // given
      val expression = "3 + 4 + 5"

      // when
      val splitter = Splitter(expression)

      // then
      splitter.left shouldBe 3
      splitter.right shouldBe 4
      splitter.operator shouldBe Operator.PLUS
      splitter.hasOther shouldBe true
      splitter.other shouldBe "+ 5"
    }
  }

  describe("뺄셈 문자열 분리") {
    it("뺄셈 이항식일 경우 숫자와 연산자를 분리한다.") {
      // given
      val expression = "3 - 4"

      // when
      val splitter = Splitter(expression)

      // then
      splitter.left shouldBe 3
      splitter.right shouldBe 4
      splitter.operator shouldBe Operator.MINUS
      splitter.hasOther shouldBe false
    }

    it("뺄셈 삼항식일 경우 숫자, 연산자, 나머지 식을 분리한다.") {
      // given
      val expression = "3 - 4 - 5"

      // when
      val splitter = Splitter(expression)

      // then
      splitter.left shouldBe 3
      splitter.right shouldBe 4
      splitter.operator shouldBe Operator.MINUS
      splitter.hasOther shouldBe true
      splitter.other shouldBe "- 5"
    }
  }

  describe("곱셈 문자열 분리") {
    it("곱셈 이항식일 경우 숫자와 연산자를 분리한다.") {
      // given
      val expression = "3 * 4"

      // when
      val splitter = Splitter(expression)

      // then
      splitter.left shouldBe 3
      splitter.right shouldBe 4
      splitter.operator shouldBe Operator.MULTIPLE
      splitter.hasOther shouldBe false
    }

    it("곱셈 삼항식일 경우 숫자, 연산자, 나머지 식을 분리한다.") {
      // given
      val expression = "3 * 4 * 5"

      // when
      val splitter = Splitter(expression)

      // then
      splitter.left shouldBe 3
      splitter.right shouldBe 4
      splitter.operator shouldBe Operator.MULTIPLE
      splitter.hasOther shouldBe true
      splitter.other shouldBe "* 5"
    }
  }

  describe("나눗셈 문자열 분리") {
    it("나눗셈 이항식일 경우 숫자와 연산자를 분리한다.") {
      // given
      val expression = "3 * 4"

      // when
      val splitter = Splitter(expression)

      // then
      splitter.left shouldBe 3
      splitter.right shouldBe 4
      splitter.operator shouldBe Operator.DIVIDE
      splitter.hasOther shouldBe false
    }

    it("나눗셈 삼항식일 경우 숫자, 연산자, 나머지 식을 분리한다.") {
      // given
      val expression = "3 * 4 * 5"

      // when
      val splitter = Splitter(expression)

      // then
      splitter.left shouldBe 3
      splitter.right shouldBe 4
      splitter.operator shouldBe Operator.DIVIDE
      splitter.hasOther shouldBe true
      splitter.other shouldBe "* 5"
    }
  }
})
