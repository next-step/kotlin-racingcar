package calculator

enum class Operator(val operator: String, val calculate: (Double, Double) -> (Double)) {
    PLUS("+", { prev, next -> prev + next }),
    MINUS("-", { prev, next -> prev - next }),
    MULTIPLE("*", { prev, next -> prev * next }),
    DIVISION("/", { prev, next -> prev / next });

    companion object {
        fun find(input: String) = values().find { it.operator == input }
            ?: throw IllegalArgumentException("Operator not allowed.")
    }
}
