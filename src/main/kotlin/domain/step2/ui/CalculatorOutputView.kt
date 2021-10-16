package domain.step2.ui

import global.strategy.output.OutputStrategy

class CalculatorOutputView(private val outputStrategy: OutputStrategy) {
    fun outputResult(result: String) = outputStrategy.execute(result)
}
