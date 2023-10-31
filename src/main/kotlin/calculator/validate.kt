package calculator

fun isOdd(number: Int) = number % 2 == 1
fun isEven(number: Int) = number % 2 == 0
fun isEvenAndDigit(item: String, number: Int) = isEven(number) && isAllDigits(item)
fun isOddAndOperator(item: String, number: Int) = isOdd(number) && isValidOperator(item)
fun isAllDigits(str: String) = str.all { it.isDigit() }
fun isValidOperator(str: String) = Operator.isInEnum(str)

val validateNull = { input: String? ->
    if (input == null) throw IllegalArgumentException("null 이면 안됩니다")
    input
}

val validateInputExpression = { input: String ->
    input.split(" ").withIndex().forEach { (index, item) ->
        if (!(isOddAndOperator(item, index) || isEvenAndDigit(item, index))) {
            throw IllegalArgumentException("잘못된 Input 입력했습니다")
        }
    }
    input
}

val validateInput = { input: String? ->
    validateNull(input)!!.let(validateInputExpression)
    input
}
