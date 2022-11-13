package calculator

class Calculator {

    fun calculate(input: String?): Int {
        ValidCheck.checkValid(input)

        val operationList = input!!.calculateOperationList()
        val numberList = input.calculateNumberList()

        var result = numberList[0]
        for (i in 1 until numberList.size) {
            val operation = operationList[i - 1]
            result = operation.operation(result, numberList[i])
        }
        return result
    }
}
