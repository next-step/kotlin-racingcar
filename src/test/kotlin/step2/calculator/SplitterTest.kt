package step2.calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class SplitterTest : DescribeSpec({
    describe("덧셈 문자열 분리") {
        it("덧셈 이항식일 경우 숫자와 연산자를 분리한다.") {
            val expression = listOf<String>("3", "+", "4")

            val splitter = Splitter(expression)

            splitter.left shouldBe 3
            splitter.right shouldBe 4
            splitter.arithmeticArithmeticParameter shouldBe ArithmeticParameter.PLUS
            splitter.hasOther shouldBe false
        }

        it("덧셈 삼항식일 경우 숫자, 연산자, 나머지 식을 분리한다.") {
            val expression = listOf<String>("3", "+", "4", "+", "5")

            val splitter = Splitter(expression)

            splitter.left shouldBe 3
            splitter.right shouldBe 4
            splitter.arithmeticArithmeticParameter shouldBe ArithmeticParameter.PLUS
            splitter.hasOther shouldBe true
            splitter.other shouldBe listOf("+", "5")
        }
    }

    describe("뺄셈 문자열 분리") {
        it("뺄셈 이항식일 경우 숫자와 연산자를 분리한다.") {
            val expression = listOf<String>("3", "-", "4")

            val splitter = Splitter(expression)

            splitter.left shouldBe 3
            splitter.right shouldBe 4
            splitter.arithmeticArithmeticParameter shouldBe ArithmeticParameter.MINUS
            splitter.hasOther shouldBe false
        }

        it("뺄셈 삼항식일 경우 숫자, 연산자, 나머지 식을 분리한다.") {
            val expression = listOf<String>("3", "-", "4", "-", "5")

            val splitter = Splitter(expression)

            splitter.left shouldBe 3
            splitter.right shouldBe 4
            splitter.arithmeticArithmeticParameter shouldBe ArithmeticParameter.MINUS
            splitter.hasOther shouldBe true
            splitter.other shouldBe listOf("-", "5")
        }
    }

    describe("곱셈 문자열 분리") {
        it("곱셈 이항식일 경우 숫자와 연산자를 분리한다.") {
            val expression = listOf<String>("3", "*", "4")

            val splitter = Splitter(expression)

            splitter.left shouldBe 3
            splitter.right shouldBe 4
            splitter.arithmeticArithmeticParameter shouldBe ArithmeticParameter.MULTIPLE
            splitter.hasOther shouldBe false
        }

        it("곱셈 삼항식일 경우 숫자, 연산자, 나머지 식을 분리한다.") {
            val expression = listOf<String>("3", "*", "4", "*", "5")

            val splitter = Splitter(expression)

            splitter.left shouldBe 3
            splitter.right shouldBe 4
            splitter.arithmeticArithmeticParameter shouldBe ArithmeticParameter.MULTIPLE
            splitter.hasOther shouldBe true
            splitter.other shouldBe listOf("*", "5")
        }
    }

    describe("나눗셈 문자열 분리") {
        it("나눗셈 이항식일 경우 숫자와 연산자를 분리한다.") {
            val expression = listOf<String>("3", "/", "4")

            val splitter = Splitter(expression)

            splitter.left shouldBe 3
            splitter.right shouldBe 4
            splitter.arithmeticArithmeticParameter shouldBe ArithmeticParameter.DIVIDE
            splitter.hasOther shouldBe false
        }

        it("나눗셈 삼항식일 경우 숫자, 연산자, 나머지 식을 분리한다.") {
            val expression = listOf<String>("3", "/", "4", "/", "5")

            val splitter = Splitter(expression)

            splitter.left shouldBe 3
            splitter.right shouldBe 4
            splitter.arithmeticArithmeticParameter shouldBe ArithmeticParameter.DIVIDE
            splitter.hasOther shouldBe true
            splitter.other shouldBe listOf("/", "5")
        }
    }

    describe("에러 처리") {
        it("입력 값이 빈 문자열인 경우 IllegalArgumentException 를 던진다.") {
            val input = listOf("")

            val exception = shouldThrow<IllegalArgumentException> {
                Splitter(input)
            }

            exception.message shouldBe "유효하지 않은 입력 값입니다."
        }

        it("입력 값의 사칙연산 기호가 잘못된 경우 IllegalArgumentException 를 던진다.") {
            val input = listOf("5", "%", "3")

            val exception = shouldThrow<IllegalArgumentException> {
                Splitter(input)
            }

            exception.message shouldBe "유효하지 않은 입력 값입니다."
        }

        it("입력 값의 띄어쓰기가 잘못된 경우 IllegalArgumentException 를 던진다.") {
            val input = listOf("5", " ", "+", "3")

            val exception = shouldThrow<IllegalArgumentException> {
                Splitter(input)
            }

            exception.message shouldBe "유효하지 않은 입력 값입니다."
        }
    }
})
