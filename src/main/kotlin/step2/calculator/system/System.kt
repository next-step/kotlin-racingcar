package step2.calculator.system

import step2.calculator.system.component.Component
import step2.calculator.system.component.Numeric

interface System {
    fun compute(previousResult: Numeric, previousInput: Component, request: Component): Memory
}
