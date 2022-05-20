package calculator

class Calculator {
    fun calculate(input: String) : Int {
        validateInput(input)

        val splitInput = input.split(" ")
        var result = splitInput[0].toInt()

        for(i in 1 until splitInput.size step (2)) {
            result = Operator.makeOperator(splitInput[i]).expression(result, splitInput[i+1].toInt())
        }

        return result
    }

    private fun validateInput(input: String) {
        require(input.isNotBlank()) { "잘못된 입력값입니다." }
    }
}
