package calculator.integration

import calculator.Calculator
import calculator.view.InputViewImpl
import org.junit.jupiter.api.Test

class IntegratedTest {
    @Test
    fun `통합 테스트`() {
        val calculator = Calculator(InputViewImpl(readlnOrNull = { readlnOrNull() }))

        val result = calculator.calculate()

        println("result = $result")
    }
}
