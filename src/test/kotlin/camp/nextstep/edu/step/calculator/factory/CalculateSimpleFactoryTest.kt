package camp.nextstep.edu.step.calculator.factory

import camp.nextstep.edu.step.calculator.domain.MedianResult
import camp.nextstep.edu.step.calculator.domain.Requester
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName

@DisplayName("계산 팩토리는")
class CalculateSimpleFactoryTest : BehaviorSpec({
    val stubCalculateSimpleFactory = CalculateSimpleFactory

    Given("문자열 수식이 주어지고") {
        val stringExpression = Requester(expression = "2 + 3 * 4 / 2").splitExpression()

        When("문자열 수식을 계산하면") {
            val result = stubCalculateSimpleFactory.calculateByStringExpressionNumbers(numbers = stringExpression)

            Then("계산 결과를 반환한다") {
                result shouldBe MedianResult.of(medianResult = 10L)
            }
        }
    }

})
