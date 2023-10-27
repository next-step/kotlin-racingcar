package calculator.integration

import calculator.Formula
import calculator.view.InputView
import org.junit.jupiter.api.Test

class IntegratedTest {
    @Test
    fun `통합 테스트`() {
        val formula = Formula(InputView.input { readln() })

        val result = formula.calculateFormula()

        println("result = $result")
    }
}
