class StringCalculator {
    fun calculate(input: String): Int {
        if (input.isBlank()) {
            throw IllegalArgumentException("입력값이 null이거나 빈 공백 문자입니다.")
        }
        val splitInput = input.split(" ")
        var result = splitInput.first().toIntOrNull() ?: throw IllegalArgumentException("입력값이 잘못되었습니다.")

        for (index in 1 until splitInput.size step 2) {
            val operator = splitInput[index]
            val targetNumber = splitInput[index + 1].toIntOrNull() ?: throw IllegalArgumentException("입력값이 잘못되었습니다.")
        }

        return result
    }
}
