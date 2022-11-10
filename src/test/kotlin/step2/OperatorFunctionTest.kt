package step2

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.assertThrows
import step2.OperatorSign.DIVIDE
import step2.OperatorSign.MINUS
import step2.OperatorSign.MULTIPLE
import step2.OperatorSign.PLUS
import java.lang.IllegalStateException

class OperatorFunctionTest : FunSpec({
    context("OperatorFunction") {
        test("plus 함수") {
            OperatorFunction.plus(1, 3) shouldBe 4
        }

        test("minus 함수") {
            OperatorFunction.minus(10, 3) shouldBe 7
        }

        test("multiple 함수") {
            OperatorFunction.multiple(3, 4) shouldBe 12
        }

        test("divide 함수") {
            OperatorFunction.divide(12, 3) shouldBe 4
        }

        test("divide 함수는 0으로 나누면 에러가 발생한다.") {
            val exception = assertThrows<IllegalStateException> { OperatorFunction.divide(12, 0) }
            exception.message shouldBe "0 으로 숫자를 나눌 수 없습니다."
        }

        context("get 함수는") {
            test("연산 기호에 해당하는 연산 함수를 반환한다.") {
                // given
                val plusFunction = OperatorFunction.get(operatorSign = PLUS)
                val minusFunction = OperatorFunction.get(operatorSign = MINUS)
                val multipleFunction = OperatorFunction.get(operatorSign = MULTIPLE)
                val divideFunction = OperatorFunction.get(operatorSign = DIVIDE)
                // when & then
                plusFunction(1, 2) shouldBe 3
                minusFunction(3, 4) shouldBe -1
                multipleFunction(3, 4) shouldBe 12
                divideFunction(10, 2) shouldBe 5
            }
        }
    }
})
