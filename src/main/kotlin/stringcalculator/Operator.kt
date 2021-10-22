package stringcalculator

enum class Operator(val operatorString: String, val execute: (operational: Operational) -> Int) {
    ADD("+", { operational: Operational -> operational.leftNum + operational.rightNum }),
    SUBTRACT("-", { operational: Operational -> operational.leftNum - operational.rightNum }),
    MULTIPLY("*", { operational: Operational -> operational.leftNum * operational.rightNum }),
    DIVIDE("/", { operational: Operational -> operational.leftNum / operational.rightNum });

    companion object {
        fun fromOperatorString(operatorString: String): Operator {
            return values().first { it.operatorString == operatorString }
        }
    }
}
