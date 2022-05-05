package step2

class Calculator {

    fun calculate(input: String): Int {
        val stringExceptSpaces = input.replace(" ", "")
        var result = stringExceptSpaces[0].digitToInt()
        for (i in 1 until stringExceptSpaces.length step 2) {
            val operator = Operator.of(stringExceptSpaces[i])
            result = operator.operate(result, stringExceptSpaces[i+1].digitToInt())
        }

        return result
    }
}
