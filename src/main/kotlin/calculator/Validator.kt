package calculator

class Validator {
    fun validate(s: String?) {
        isNullOrBlank(s)
        if (s != null) isArithmeticOperation(s)
    }

    private fun isNullOrBlank(s: String?) {
        if (s.isNullOrBlank()) throw IllegalArgumentException()
    }

    private fun isArithmeticOperation(s: String) {
        val s1 = s.replace(" ", "")
        val regex = Regex("[^+\\-*/0-9]")
        if (regex.containsMatchIn(s1)) throw IllegalArgumentException()
    }
}
