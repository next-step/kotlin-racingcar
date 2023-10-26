package study

import StringCalculator
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import org.assertj.core.api.Assertions.assertThatThrownBy

class StringCalculatorTest : StringSpec({
    "plusTest" {
        StringCalculator.Operator.plus(1, 2).shouldBe(3)
    }

    "minusTest" {
        StringCalculator.Operator.minus(5, 2).shouldBe(3)
    }

    "multiplyTest" {
        StringCalculator.Operator.multiply(4, 2).shouldBe(8)
    }

    "divideTest" {
        StringCalculator.Operator.divide(16, 2).shouldBe(8)
    }

    "formulaTest" {
        StringCalculator.evaluate("2 + 3 * 4 / 2").shouldBe(10)
    }

    "emptyFormulaTest" {
        assertThatThrownBy {
            StringCalculator.evaluate("   ")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("empty formula")
    }

    "wrongOperationTest" {
        assertThatThrownBy {
            StringCalculator.evaluate("2 # 4")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("invalid operation")
    }
})
