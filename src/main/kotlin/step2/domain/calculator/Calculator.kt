package step2.domain.calculator

import step2.domain.calculator.model.InputOperationCommand

interface Calculator<T> {

    fun calculate(inputOperationCommandList: List<InputOperationCommand>): T
}
