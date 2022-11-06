package step2.calculator.system.component

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FeatureSpec
import io.kotest.matchers.shouldBe

class NumericTest : FeatureSpec({

    val positiveNumberString = "1.1"
    val positiveNumber = 1.1
    val negativeNumberString = "-1.1"
    val negativeNumber = -1.1
    val zeroString = "0"
    val zero = 0.0

    val notNumber = "qq1werd"

    feature("from") {
        scenario("실수인 문자열을 넣으면 정상 동작한다.") {
            Numeric.from(positiveNumberString).value shouldBe positiveNumber
            Numeric.from(negativeNumberString).value shouldBe negativeNumber
            Numeric.from(zeroString).value shouldBe zero
        }

        scenario("실수가 아닌 문자열을 넣으면 에러를 반환한다.") {
            shouldThrow<IllegalArgumentException> {
                Numeric.from(notNumber)
            }
        }
    }

    feature("isNumeric") {
        scenario("실수인 문자열을 넣으면 true 를 반환한다.") {
            Numeric.isNumeric(positiveNumberString) shouldBe true
            Numeric.isNumeric(negativeNumberString) shouldBe true
            Numeric.isNumeric(zeroString) shouldBe true
        }

        scenario("실수가 아닌 문자열을 넣으면 false 를 반환한다.") {
            Numeric.isNumeric(notNumber) shouldBe false
        }
    }
})
