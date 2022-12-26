package step2.calculator.vo

interface CalculatorInput {
    companion object
}

fun CalculatorInput.Companion.from(input: String): CalculatorInput {
    return when {
        input.isTypeOf(Number::class.java) -> Number(input.toInt())
        input.isTypeOf(Operation::class.java) -> Operation.from(input)
        else -> throw IllegalArgumentException("알 수 없는 입력값.")
    }
}


fun String.isTypeOf(type: Class<out CalculatorInput>): Boolean {
    return when {
        type.isAssignableFrom(Number::class.java) -> {
            runCatching {
                Number(this.toInt())
            }.isSuccess
        }

        type.isAssignableFrom(Operation::class.java) -> {
            kotlin.runCatching {
                Operation.from(this)
            }.isSuccess
        }

        else -> {
            false
        }
    }
}
