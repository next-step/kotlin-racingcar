package calculator

import calculator.exceptions.OperationBetweenNumbersException

object Calculator {
    fun calculate(input: String?): Double = calculate(InputParser.validateInput(input))

    private fun calculate(inputList: List<String>): Double {
        val numbersList = processNumbers(inputList)
        val operations: ArrayDeque<Operation> = ArrayDeque(processOperations(inputList))

        return numbersList
            .drop(1)
            .fold(numbersList.first()) { result, number ->
                operations
                    .removeFirst()
                    .apply(result, number)
            }
    }

    private fun processNumbers(inputList: List<String>) =
        inputList
            .filterIndexed { index, _ -> index % 2 == 0 }
            .map { formatNumber(it) }

    private fun formatNumber(inputNumber: String): Double = inputNumber.toDoubleOrNull() ?: throw OperationBetweenNumbersException()

    private fun processOperations(inputList: List<String>): List<Operation> =
        inputList.filterIndexed { index, _ -> index % 2 != 0 }.map { Operation.from(it) }
}
