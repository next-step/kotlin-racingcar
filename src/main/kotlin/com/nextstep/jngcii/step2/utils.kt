package com.nextstep.jngcii.step2

fun String.convertToRequests(): Requests {
    val numbers = mutableListOf<POperator>()
    val operators = mutableListOf<Operator>()

    val inputs = this.split(" ")

    inputs.forEachIndexed { index, input ->
        if (index % 2 == 1) {
            operators.add(Operator.of(input))
        } else {
            val isEnd = index == inputs.size - 1

            numbers.add(POperator(input, isEnd))
        }
    }

    return Requests(numbers, operators)
}
