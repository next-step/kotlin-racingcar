package step2.calculator.system.component

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FeatureSpec
import io.kotest.matchers.shouldBe

/**
 * @see LazyFunction
 */
class LazyFunctionTest : FeatureSpec({

    val plusSign = "+"
    val minusSign = "-"
    val multiplySign = "*"
    val divideSign = "/"

    val testNumber1 = 3.14
    val testNumber2 = 1.77
    val zero = 0.0

    feature("사칙연산") {
        scenario("PLUS : 잘 더한다.") {
            val generalAdd = LazyFunction.PLUS.evaluate(testNumber1, testNumber2)
            val addZero = LazyFunction.PLUS.evaluate(testNumber1, zero)

            generalAdd shouldBe testNumber1 + testNumber2
            addZero shouldBe testNumber1
        }

        scenario("MINUS : 잘 뻰다.") {
            val generalMinus = LazyFunction.MINUS.evaluate(testNumber1, testNumber2)
            val minusZero = LazyFunction.MINUS.evaluate(testNumber1, zero)

            generalMinus shouldBe testNumber1 - testNumber2
            minusZero shouldBe testNumber1
        }

        scenario("MULTIPLY : 잘 곱한다.") {
            val generalMultiply = LazyFunction.MULTIPLY.evaluate(testNumber1, testNumber2)
            val multiplyZero = LazyFunction.MULTIPLY.evaluate(testNumber1, zero)

            generalMultiply shouldBe testNumber1 * testNumber2
            multiplyZero shouldBe zero
        }

        scenario("DIVIDE : 잘 나눈다.") {
            val generalDivide = LazyFunction.DIVIDE.evaluate(testNumber1, testNumber2)
            val divideZero = LazyFunction.DIVIDE.evaluate(zero, testNumber1)

            generalDivide shouldBe testNumber1 / testNumber2
            divideZero shouldBe zero
        }

        scenario("DIVIDE : 0으로 나누면 에러를 반환한다.") {
            shouldThrow<IllegalArgumentException> {
                LazyFunction.DIVIDE.evaluate(testNumber1, zero)
            }
        }
    }

    feature("from") {
        scenario("사칙 연산 기호를 넣으면 정상 동작한다.") {
            val plus = LazyFunction.from(plusSign)
            val minus = LazyFunction.from(minusSign)
            val multiply = LazyFunction.from(multiplySign)
            val divide = LazyFunction.from(divideSign)

            plus shouldBe LazyFunction.PLUS
            minus shouldBe LazyFunction.MINUS
            multiply shouldBe LazyFunction.MULTIPLY
            divide shouldBe LazyFunction.DIVIDE
        }

        scenario("사칙 연산이 아닌 기호를 넣으면 에러를 반환한다.") {
            val testCase = "!@#$%^&()"

            testCase.split("").map {
                shouldThrow<IllegalArgumentException> {
                    LazyFunction.from(it)
                }
            }
        }
    }

    feature("isLazyFunction") {
        scenario("사칙 연산 기호를 넣으면 true 를 반환한다.") {
            LazyFunction.isLazyFunction(plusSign) shouldBe true
            LazyFunction.isLazyFunction(minusSign) shouldBe true
            LazyFunction.isLazyFunction(multiplySign) shouldBe true
            LazyFunction.isLazyFunction(divideSign) shouldBe true
        }

        scenario("사칙 연산이 아닌 기호를 넣으면 false 를 반환한다..") {
            val testCase = "!@#$%^&()"

            testCase.split("").map {
                LazyFunction.isLazyFunction(it) shouldBe false
            }
        }
    }
})
