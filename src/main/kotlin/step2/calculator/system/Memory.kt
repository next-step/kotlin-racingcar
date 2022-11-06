package step2.calculator.system

import step2.calculator.system.component.Component

data class Memory(
    val value: Double,
    val previous: Component
)
