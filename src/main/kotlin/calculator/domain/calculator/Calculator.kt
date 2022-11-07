package calculator.domain.calculator

import calculator.domain.calculator.model.InputOperationCommand

interface Calculator<T> {

    fun calculate(inputOperationCommandList: List<InputOperationCommand>): T
}
