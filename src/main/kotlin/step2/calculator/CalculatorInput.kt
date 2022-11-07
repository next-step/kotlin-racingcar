package step2.calculator

import step2.calculator.system.component.Component
import step2.calculator.system.component.ComponentConverter

data class CalculatorInput(
    val buttonList: List<Component>
) {

    companion object {
        fun from(input: UserInput): CalculatorInput {
            return CalculatorInput(
                input.value.map { ComponentConverter.convert(it) }
            )
        }
    }
}
