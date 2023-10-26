package study

import StringCalculator
import io.kotest.core.spec.style.StringSpec
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy

class StringCalculatorTest : StringSpec({
    "plusTest" {
        assertThat(StringCalculator.Operator.plus(1, 2) == 3).isTrue()
    }

    "minusTest" {
        assertThat(StringCalculator.Operator.minus(5, 2) == 3).isTrue()
    }

    "multiplyTest" {
        assertThat(StringCalculator.Operator.multiply(4, 2) == 8).isTrue()
    }

    "divideTest" {
        assertThat(StringCalculator.Operator.divide(16, 2) == 8).isTrue()
    }

    "formulaTest" {
        assertThat(StringCalculator.evaluate("2 + 3 * 4 / 2") == 10).isTrue()
    }

    "emptyFormulaTest" {
        assertThatThrownBy {
            StringCalculator.evaluate("   ")
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    "wrongOperationTest" {
        assertThatThrownBy {
            StringCalculator.evaluate("2 # 4")
        }.isInstanceOf(IllegalArgumentException::class.java)
    }
})
