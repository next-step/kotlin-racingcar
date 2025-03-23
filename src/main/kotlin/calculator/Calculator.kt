package calculator

object Calculator {


    fun validateInput(input: String?): String {
        if (input.isNullOrBlank()) throw IllegalArgumentException("Input is null or blank")
        if (input.any { it !in ALLOWED_CHARS }) throw IllegalArgumentException("Input has invalid characters")
        return input
    }

}

const val ALLOWED_CHARS = "0123456789+-*/"
