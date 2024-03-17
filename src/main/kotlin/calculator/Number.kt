package calculator

class Number(
    val number: Double
) {

    companion object {
        val ZERO = Number(0.0)

        fun fromString(stringNumber: String): Number {
            when {
                isNumeric(stringNumber) -> return Number(stringNumber.toDouble())
                else -> throw IllegalArgumentException("$stringNumber is not a number.")
            }
        }

        fun isNumeric(toCheck: String): Boolean {
            val regex = "-?[0-9]+(\\.[0-9]+)?".toRegex()
            return toCheck.matches(regex)
        }
    }
}