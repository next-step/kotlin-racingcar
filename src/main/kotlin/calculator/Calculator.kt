package calculator

object Calculator {

    fun execute(input: String?): Double {
        require(!input.isNullOrBlank()) { "Input is null or blank." }

        val inputList = input.trim().split(" ")
        var result = inputList[0].toDouble()
        for (i in 0..inputList.size - 2 step 2) {
            val operator = inputList[i + 1]
            val operand1 = result
            val operand2 = inputList[i + 2].toDouble()
            result = Operator.operatorByValue(operator).calculate(operand1, operand2)
        }

        return result
    }
}
