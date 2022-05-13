package com.nextstep.jngcii.step2

class Computer(
    private val calculator: Calculator
) {
    fun compute(requests: Requests): Double {
        var left = requests.numbers.first()

        for (index in 0 until requests.operators.size) {
            if (left.isEnd) break

            val right = requests.numbers[index + 1]
            val operator = requests.operators[index]

            left = calculator.run(left, right, operator)
        }

        return left.value.toDouble()
    }
}
