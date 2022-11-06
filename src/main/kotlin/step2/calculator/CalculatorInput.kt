package step2.calculator

import step2.calculator.system.component.Component
import step2.calculator.system.component.ComponentConverter

data class CalculatorInput(
    val buttonList: List<Component>
) {

    companion object {
        @JvmStatic
        fun from(input: List<String>): CalculatorInput {
            return CalculatorInput(
                input.map { ComponentConverter.convert(it) }
            )
        }
    }
}
