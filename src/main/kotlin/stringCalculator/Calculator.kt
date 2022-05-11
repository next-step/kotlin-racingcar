package stringCalculator

class Calculator {

    fun calculate(input: String): Int {
        val validator = Validator()
        validator.isValidInput(input)

        val inputList = input.split(" ")
        val numbers = inputList.filter { validator.isNumber(it) }
        val operators = inputList.filter { validator.isOperator(it.first()) }

        var result = numbers[0].toInt()

        numbers.drop(1)
            .zip(operators) { number, operator ->
                result = Evaluation.find(operator).applyOperator(result, number.toInt())
            }
        return result
    }


}
