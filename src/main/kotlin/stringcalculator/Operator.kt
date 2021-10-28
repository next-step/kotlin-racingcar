package stringcalculator

enum class Operator(val value: String, val execute: (Int, Int) -> Int) {
    ADD("+", { leftNum, rightNum -> leftNum + rightNum }),
    SUBTRACT("-", { leftNum, rightNum -> leftNum - rightNum }),
    MULTIPLY("*", { leftNum, rightNum -> leftNum * rightNum }),
    DIVIDE("/", { leftNum, rightNum -> leftNum / rightNum });

    companion object {
        fun fromOperatorString(value: String): Operator {
            return values().first { it.value == value }
        }
    }
}
