package calculator

fun execute(input: String): Int {
    val inputChars = input.toCharArray()
        .filterNot { it.isWhitespace() }

    var result = inputChars[0].toString().toInt()
    var currentOperator: Char? = null

    for (inputChar in inputChars) {
        if (isMathOperator(inputChar)) {
            currentOperator = inputChar
            continue
        }
        
        if(isCalculable(currentOperator, inputChar)) {
            result = calculate(currentOperator!!, result, inputChar.toString().toInt())
            currentOperator = null
        }
    }
    
    return result
}

private fun isMathOperator(inputChar: Char): Boolean {
    return inputChar in setOf('+', '-', '*', '/')
}

private fun isCalculable(currentOperator: Char?, inputChar: Char): Boolean {
    return currentOperator != null && inputChar.isDigit()
}

private fun calculate(currentOperator: Char, result: Int, inputNum: Int): Int {
    return when (currentOperator) {
        '+' -> add(result, inputNum)
        '-' -> subtract(result, inputNum)
        '*' -> multiply(result, inputNum)
        '/' -> divide(result, inputNum)
        else -> result
    }
}
