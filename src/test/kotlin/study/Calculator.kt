package study

class Calculator(
    var value: Int = 0,
    var result: Int = 0,
) {
    companion object {
        private val regex1 = "\\s+".toRegex()
        private val regex2 = "\\D+".toRegex()
        private val regex3 = "[\\+\\-\\*\\/]".toRegex()
    }

    fun addition() {
        this.result += this.value
    }

    fun subtraction() {
        this.result -= this.value
    }

    fun multiplication() {
        this.result *= this.value
    }

    fun division() {
        this.result /= this.value
    }

    fun operation(operator: String) {
        when (operator) {
            "+" -> addition()
            "-" -> subtraction()
            "*" -> multiplication()
            "/" -> division()
            else -> throw IllegalArgumentException()
        }
    }

    fun input(): String {
        print("계산기 입력 값: ")
        val text = readlnOrNull()
        println(text)

        if (text.isNullOrBlank()) {
            throw IllegalArgumentException()
        }
        return text
    }

    fun validateText(text: String) {
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
                    if (presentStage == "operator") {
                        throw IllegalArgumentException()
                    }

                    operator = result
                    presentStage = "operator"
                }
                else -> {
                    if (presentStage == "number") {
                        throw IllegalArgumentException()
                    }

                    if (operator.isEmpty()) {
                        this.result = result.toInt()
                    } else {
                        this.value = result.toInt()
                        this.operation(operator)
                    }
                    presentStage = "number"
                }
            }
        }
    }
}
