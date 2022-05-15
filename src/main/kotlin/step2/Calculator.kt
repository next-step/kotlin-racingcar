package step2

fun calculate(inputString: String): Double {
    require(inputString.isNotBlank()) { "Invalid Input" }

    val inputs = inputString.split(" ")
    var result = inputs[0].toValue()

    for (index in 1 until inputs.size step 2) {
        result = when (inputs[index]) {
            "+" -> result + inputs[index + 1].toValue()
            "-" -> result - inputs[index + 1].toValue()
            "*" -> result * inputs[index + 1].toValue()
            "/" -> result / inputs[index + 1].toValue()
            else -> throw IllegalArgumentException("Invalid Operation Type")
        }
    }

    return result
}

fun String.toValue(): Double {
    return this.toDoubleOrNull() ?: throw IllegalArgumentException("Invalid Value Type")
}
