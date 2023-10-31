package step2

class Calculator {
    fun calculate(input: Input): Int {
        val formulaList = FormulaList(input.text.split(Regex("\\s+")))

        val (numberList, arithmeticList) = formulaList.toSeparatedList()
        return operate(numberList, arithmeticList)
    }

    private fun operate(numberList: List<Int>, arithmeticList: List<Arithmetic>): Int {
        var result = numberList[0]

        val expressionCount = arithmeticList.size
        for (i in 0 until expressionCount) {
            result = arithmeticList[i].calculate(result, numberList[i + 1])
        }

        return result
    }
}
