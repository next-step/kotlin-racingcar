package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec

class ExpressionKoTest : DescribeSpec({
    describe("나눗셈 유효성 검사 테스트") {
        it("나누는 수가 0인 경우") {
            val prevNumber = 3.0
            val nextNumber = 0.0
            val operator = Operator.DIVISION

            shouldThrow<IllegalArgumentException> {
                Expression(prevNumber, operator, nextNumber)
            }
        }
    }
})
