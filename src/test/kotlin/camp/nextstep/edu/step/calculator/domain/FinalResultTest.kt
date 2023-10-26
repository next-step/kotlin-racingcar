package camp.nextstep.edu.step.calculator.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("계산 결과는")
class FinalResultTest {

    @Nested
    class `생성 시` {
        @Test
        fun `계산 결과를 가진다`() {
            // given
            val midCalculatorResult = MedianResult.of(medianResult= 10L)

            // when
            val finalResult = FinalResult.of(medianResult = midCalculatorResult)

            // then
            assertThat(finalResult.calculationResult).isEqualTo(10L)
        }
    }
}
