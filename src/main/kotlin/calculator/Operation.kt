package calculator

enum class Operation(val execute: (Int, Int) -> Int) {
    ADD({ num1, num2 ->
        num1 + num2
    }),

    SUBTRACT({ num1, num2 ->
        num1 - num2
    }),

    MULTIPLY({ num1, num2 ->
        num1 * num2
    }),

    DIVIDE({ num1, num2 ->
        require(num2 != 0) { "Not divisible by zero" }
        num1 / num2
    }),
}
