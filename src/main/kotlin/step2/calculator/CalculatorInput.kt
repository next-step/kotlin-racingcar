package step2.calculator

import step2.calculator.system.component.Component
import step2.calculator.system.component.ComponentConverter
import step2.user.UserInput

data class CalculatorInput(
    val buttons: List<Component>
) {

    companion object {
        fun from(input: UserInput): CalculatorInput {
            return CalculatorInput(
                input.value.map { ComponentConverter.convert(it) }
            )
        }
    }
}
