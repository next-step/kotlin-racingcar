package calculator

class Validator {
    fun validate(input: String?) {
        validateNullOrBlank(input)
        if (input != null) validateArithmeticOperation(input)
    }

    private fun validateNullOrBlank(s: String?) {
        if (s.isNullOrBlank()) throw IllegalArgumentException()
    }

    private fun validateArithmeticOperation(s: String) {
        val regex = Regex("[^+\\-*/0-9\\s]")
        if (regex.containsMatchIn(s)) throw IllegalArgumentException()
    }
}
