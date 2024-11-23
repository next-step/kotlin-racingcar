package racingcar.calculator

class Calculator(inputString: UserInputString) {
    private val inputStringList: List<String> = PreProcess.splitBySpace(inputString)
    private val numbers: List<Double> = PreProcess.extractNumbers(inputStringList)
    private val operators: List<String> = PreProcess.extractOperators(inputStringList)

    fun calculate(): Double {
        var answer = numbers[0]
        for (i in operators.indices) {
            val currentOperator = Operator.getOperatorBySymbol(operators[i])
            answer = currentOperator.apply(answer, numbers[i + 1])
        }
        return answer
    }

    fun getNumbers(): List<Double> {
        return numbers
    }

    fun getOperators(): List<String> {
        return operators
    }
}
