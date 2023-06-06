package step2.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage
import step2.model.ErrorCode

class OperatorTest : DescribeSpec({

    describe(name = "Operator 연산자 변환 테스트") {
        context(name = "정의되어 있는 커맨드를 입력하면") {
            val parameterized = listOf(
                "+" to Operator.PLUS,
                "-" to Operator.MINUS,
                "*" to Operator.MULTIPLY,
                "/" to Operator.DIVIDE,
            )

            withData(ts = parameterized) {
                Operator.getOperatorByCommand(command = it.first) shouldBe it.second
            }
        }

        context(name = "정의되어 있지 않은 커맨드를 입력하면") {
            val invalidCommand = "없는 커맨드"

            val exception = shouldThrow<IllegalArgumentException> {
                Operator.getOperatorByCommand(command = invalidCommand)
            }

            it(name = "IllegalArgumentException 발생한다.") {
                exception shouldHaveMessage ErrorCode.INVALID_OPERATOR_CODE.message(invalidCommand)
            }
        }
    }
})
