package step2

object Calculator {
    private fun String.isNumeric() = matches("-?\\d+(\\.\\d+)?".toRegex())
    private fun String.isNotNumeric() = !isNumeric()
    private fun String.getOperator() = OperatorType.getOperator(this)

    fun calculate(input: String?): Double {
        val checkedInput = checkInputValidation(input)
        val dividedList = checkedInput.split(" ")
        checkElementValidation(dividedList)

        var idx = 0
        var accumulator = dividedList.first().toDouble()

        while (idx < dividedList.size) {
            val divided = dividedList[idx++]
            if (divided.isNotNumeric()) {
                val newValue = dividedList[idx++]
                require(newValue.isNumeric()) { "연산자 다음은 숫자가 와야합니다." }
                accumulator = divided.getOperator().execute(accumulator, newValue.toDouble())
            }
        }
        return accumulator
    }

    private fun checkElementValidation(list: List<String>) {
        require(list.first().isNumeric()) { "숫자 부터 입력 되어야합니다." }
        require(list.last().isNumeric()) { "식의 마지막에는 숫자가 입력되어야 합니다." }
    }

    private fun checkInputValidation(input: String?) = run {
        requireNotNull(input) { "입력이 비어서는 안됩니다." }
        require(input.isNotBlank()) { "입력이 공백 이여서는 안됩니다." }
        input
    }
}
