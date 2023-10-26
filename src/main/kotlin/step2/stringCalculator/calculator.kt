package step2.stringCalculator

fun isAllDigits(str: String) = str.all { it.isDigit() }

fun isValidOperator(str: String) = str.all { listOf('+', '-', '/', '*').contains(it) }

fun isValidInput(strList: List<String>) = strList.withIndex().all { (index, item) ->
    var bool = false
    if(index % 2 == 0 && isAllDigits(item)) bool = true
    if(index % 2 == 1 && isValidOperator(item)) bool = true
    bool
}

fun operate(operator: String, a: Double, b: Double) = when (operator) {
    "+" -> a + b
    "-" -> a - b
    "/" -> a / b
    "*" -> a * b
    else -> throw IllegalArgumentException();
}

fun getResult(inputs:List<String>): Double {
    var index = -1;
    var operator = '+'.toString();

    return inputs.fold(0.0) { acc, item ->
        index++
        var result = acc;
        if (index % 2 == 0 && isAllDigits(item))
        // 짝수 일때는 숫자
            result = operate(operator, acc, item.toDouble())
        else if (index % 2 == 1 && isValidOperator(item))
        // 홀수 일때는 연산자
            operator = item
        result
    }
}


fun calculate(input: String?) {
    if(input == null) throw IllegalArgumentException();

    val splitInputs = input.split(" ")

    if(!isValidInput(splitInputs)) throw IllegalArgumentException();

    println(getResult(splitInputs))
}


