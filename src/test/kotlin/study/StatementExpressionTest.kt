package study

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class StatementExpressionTest : DescribeSpec({
    describe("statement vs expression") {
        it("식(expression)은 값을 만들어낸다") {
            val a = 10
            val b = 20
            val expression = if (a > b) a else b

            println("expression: $expression")
            expression shouldBe b
        }
    }
})
