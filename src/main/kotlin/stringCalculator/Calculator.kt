package stringCalculator

class Calculator {

    fun calculate(input: String): Int {
        val validator = Validator()
        validator.isValidInput(input)

        val inputList = input.split(" ")
        val numbers = inputList.filter { validator.isNumber(it) }
        val operators = inputList.filter { validator.isOperator(it.first()) }

        return numbers.drop(1)
            .foldIndexed(numbers[0]) { idx, acc, num ->
                Evaluation.find(operators[idx]).applyOperator(acc.toInt(), num.toInt()).toString()
            }.toInt()
    }
}
