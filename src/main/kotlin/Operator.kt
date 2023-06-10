enum class Operator(val operator: String) {
    PLUS("+") {
        override fun calculate(preNumber: String, postNumber: String): String {
            if (!preNumber.isNum() || !postNumber.isNum()) {
                throw IllegalArgumentException("Parameter must be Number")
            }
            return (preNumber.toInt() + postNumber.toInt()).toString()
        }
    },
    MINUS("-") {
        override fun calculate(preNumber: String, postNumber: String): String {
            if (!preNumber.isNum() || !postNumber.isNum()) {
                throw IllegalArgumentException("Parameter must be Number")
            }
            return (preNumber.toInt() - postNumber.toInt()).toString()
        }
    },
    TIMES("*") {
        override fun calculate(preNumber: String, postNumber: String): String {
            if (!preNumber.isNum() || !postNumber.isNum()) {
                throw IllegalArgumentException("Parameter must be Number")
            }
            return (preNumber.toInt() * postNumber.toInt()).toString()
        }
    },
    DIVIDE("/") {
        override fun calculate(preNumber: String, postNumber: String): String {
            if (!preNumber.isNum() || !postNumber.isNum()) {
                throw IllegalArgumentException("Parameter must be Number")
            }
            return (preNumber.toInt() / postNumber.toInt()).toString()
        }
    };

    abstract fun calculate(preNumber: String, postNumber: String): String

    companion object {

        fun getOperator(operatorInput: String): Operator {
            val operator = findOperator(operatorInput)
            if (operator != null) {
                return operator
            } else {
                throw IllegalArgumentException("Cannot find operator")
            }
        }
        private fun findOperator(operator: String): Operator? = values().firstOrNull { it.operator == operator }
    }
}

private fun String.isNum(): Boolean {
    this.forEach {
        char ->

        val charConvertedToCode = char.code

        if (charConvertedToCode > 57 || charConvertedToCode < 48) {
            return false
        }
    }
    return true
}
