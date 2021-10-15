package step2.ui

import step2.strategy.output.OutputStrategy

class CalculatorOutputView(private val outputStrategy: OutputStrategy) {
    fun outputResult(result: String) = outputStrategy.execute(result)
}