package calculator

class Operator(type: String) {
    private val operatorType = getType(type)

    enum class Type {
        PLUS,
        MINUS,
        MULTIPLE,
        DIVIDE
    }

    private fun getType(s: String): Type {
        if (s == "+") return Type.PLUS
        if (s == "-") return Type.MINUS
        if (s == "*") return Type.MULTIPLE
        if (s == "/") return Type.DIVIDE
        return Type.DIVIDE
    }

    fun calculate(current: Double, change: Double): Double {
        if (operatorType == Type.PLUS) return current + change
        if (operatorType == Type.MINUS) return current - change
        if (operatorType == Type.MULTIPLE) return current * change
        if (operatorType == Type.DIVIDE) return current / change
        return current / change
    }
}
