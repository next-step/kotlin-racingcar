package step2.calculator

import step2.calculator.system.Memory
import step2.calculator.system.System
import step2.calculator.system.component.Numeric

class CalculatorImpl(
    private val system: System
) : Calculator {

    override fun enter(input: CalculatorInput): CalculateResult {
        val result = input.buttons
            .fold(Memory(INIT_VALUE, Numeric(INIT_VALUE))) { memory, component ->
                return@fold system.compute(
                    Numeric(memory.value),
                    memory.previous,
                    component
                )
            }

        return CalculateResult(
            result.value
        )
    }

    companion object {
        private const val INIT_VALUE = 0.0
    }
}
