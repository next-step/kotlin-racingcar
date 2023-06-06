package calculator

fun calculateFromString(input: String): Int {
    val inputArray = input.split(" ".toRegex())
        .dropLastWhile { it.isEmpty() }
        .toTypedArray()
    require(inputArray.size >= 3)
    return calculate(inputArray)
}

fun calculate(arr: Array<String>): Int {
    val size = arr.size
    val num1 = arr[size - 3].toInt()
    val operator = Operator.valueOfString(arr[size - 2])
    val num2 = arr[size - 1].toInt()

    return when (size) {
        3 -> operator.execute(num1, num2)
        else -> {
            val answer = calculate(arr.copyOfRange(0, size - 2))
            return operator.execute(answer, num2)
        }
    }
}
