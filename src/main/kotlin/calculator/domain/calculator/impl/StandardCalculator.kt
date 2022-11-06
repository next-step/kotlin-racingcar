package calculator.domain.calculator.impl

import calculator.domain.calculator.Calculator
import calculator.domain.calculator.model.InputOperationCommand
import calculator.domain.operation.enums.Operator
import calculator.domain.operation.model.BinaryInputCommand

class StandardCalculator : Calculator<Int> {

    override fun calculate(inputOperationCommandList: List<InputOperationCommand>): Int {
        return sequentialOperate(inputOperationCommandList)
    }

    private fun sequentialOperate(inputOperationCommandList: List<InputOperationCommand>): Int {
        var answer = 0
        var temp: InputOperationCommand? = null

        inputOperationCommandList.windowed(size = 2, step = 1, partialWindows = true) { window: List<InputOperationCommand> ->
            var first = window.first()
            temp?.let { first = it }

            if (first.nextOperator == Operator.EMPTY_OPERATOR) run {
                answer = first.number
                return@windowed
            }

            val second = window.last()
            val inputCommand = BinaryInputCommand(first.number, second.number)

            val result = first.nextOperator.toCommand().operate(inputCommand)
            temp = InputOperationCommand(number = result, second.nextOperator)
        }
        return answer
    }
}
