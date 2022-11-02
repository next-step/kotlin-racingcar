package step2.domain.calculator

import step2.domain.calculator.model.InputOperationCommand

interface Calculator {

    fun calculate(inputOperationCommandList: List<InputOperationCommand>): Int
}