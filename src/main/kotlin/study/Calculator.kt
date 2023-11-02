package study

class Calculator(
    private var value: Int = 0,
    private var result: Double = 0.0,

) {
    companion object {
        private const val CHECK_ZERO = 0
        private const val CHECK_POINT_ONE = 1
        private const val PROCESS_KEYWORD_NUMBER = "number"
        private const val PROCESS_KEYWORD_OPERATOR = "operator"

        private val regex1 = "\\s+".toRegex()
        private val regex2 = "\\D+".toRegex()
        private val regex3 = "[\\+\\-\\*\\/]".toRegex()
    }

    fun getResult(): Any {
        return if (! (this.result % CHECK_POINT_ONE > CHECK_ZERO)) {
            this.result.toInt()
        } else {
            this.result
        }
    }

    private fun addition() {
        this.result += this.value.toDouble()
    }

    private fun subtraction() {
        this.result -= this.value.toDouble()
    }

    private fun multiplication() {
        this.result *= this.value.toDouble()
    }

    private fun division() {
        if (this.value == CHECK_ZERO) {
            throw IllegalArgumentException()
        }
        this.result /= this.value.toDouble()
    }

    private fun operation(operator: String) {
        when (operator) {
            "+" -> addition()
            "-" -> subtraction()
            "*" -> multiplication()
            "/" -> division()
            else -> throw IllegalArgumentException()
        }
    }

    private fun input(): String {
        print("계산기 입력 값: ")
        val text = readlnOrNull()
        println(text)

        if (text.isNullOrBlank()) {
            throw IllegalArgumentException()
        }
        return text
    }

    private fun validateText(text: String) {
        if (text.toIntOrNull() == null) {
            if (!text.contains(regex3)) {
                throw IllegalArgumentException()
            }
        } else {
            if (text.contains(regex2)) {
                throw IllegalArgumentException()
            }
        }
    }

    fun start() {
        var operator = ""
        var presentStage = ""

        val text = input()

        for (result in text.split(regex1)) {
            validateText(result)

            when {
                regex2.matches(result) -> {
                    if (presentStage == PROCESS_KEYWORD_OPERATOR) {
                        throw IllegalArgumentException()
                    }

                    operator = result
                    presentStage = PROCESS_KEYWORD_OPERATOR
                }
                else -> {
                    if (presentStage == PROCESS_KEYWORD_NUMBER) {
                        throw IllegalArgumentException()
                    }

                    if (operator.isEmpty()) {
                        this.result = result.toDouble()
                    } else {
                        this.value = result.toInt()
                        this.operation(operator)
                    }
                    presentStage = PROCESS_KEYWORD_NUMBER
                }
            }
        }
    }
}
