package study

import calculator.ArithmeticOperation
import calculator.StringCalculator
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import org.assertj.core.api.Assertions.assertThatThrownBy

class StringCalculatorTest : StringSpec({
    "plusTest" {
        ArithmeticOperation.Plus.run(1, 2).shouldBe(3)
    }

    "minusTest" {
        ArithmeticOperation.Minus.run(5, 2).shouldBe(3)
    }

    "multiplyTest" {
        ArithmeticOperation.Multiply.run(4, 2).shouldBe(8)
    }

    "divideTest" {
        ArithmeticOperation.Divide.run(16, 2).shouldBe(8)
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
