package stringcalculator

enum class Operator(val value: String, val execute: (operational: Operational) -> Int) {
    ADD("+", { operational: Operational -> operational.leftNum + operational.rightNum }),
    SUBTRACT("-", { operational: Operational -> operational.leftNum - operational.rightNum }),
    MULTIPLY("*", { operational: Operational -> operational.leftNum * operational.rightNum }),
    DIVIDE("/", { operational: Operational -> operational.leftNum / operational.rightNum });

    companion object {
        fun fromOperatorString(value: String): Operator {
            return values().first { it.value == value }
        }
    }
}
