package com.nextstep.jngcii.step2

private const val ONE_SIZE_BLANK = " "
private const val DIVIDE_OPERAND_FOR_CHECK = 2
private const val REMAIN_NUMBER_ONE = 1

fun String.convertToRequests(): Requests {
    val numbers = mutableListOf<Operand>()
    val operators = mutableListOf<Operator>()

    val inputs = this.split(ONE_SIZE_BLANK)

    inputs.forEachIndexed { index, input ->
        if (index % DIVIDE_OPERAND_FOR_CHECK == REMAIN_NUMBER_ONE) {
            operators.add(Operator.of(input))
        } else {
            val isEnd = index == inputs.size - 1

            numbers.add(Operand(input, isEnd))
        }
    }

    return Requests(numbers, operators)
}
