package calculator

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class CalculatorTest: DescribeSpec ({
    describe("Calculator") {
        it("더하기를 수행한다.") {
            val calculator = Calculator();

            val result = calculator.calculate("1 + 2");
            val result2 = calculator.calculate("1 + 2 + 3");

            result shouldBe 3
            result2 shouldBe 6
        }

    }
})