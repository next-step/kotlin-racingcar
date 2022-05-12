package com.nextstep.jngcii.step2

class Computer(
    private val calculator: Calculator
) {
    fun compute(requests: Requests): Int {
        var lhs = requests.numbers.first()

        for (index in 0 until requests.operators.size) {
            if (lhs.isEnd) break

            val rhs = requests.numbers[index + 1]
            val op = requests.operators[index]

            lhs = calculator.run(lhs, rhs, op)
        }

        return lhs.value
    }
}
