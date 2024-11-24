package week2.calculator

class StringAddCalculator {
    private val delimiters = mutableListOf(",", ":") // default delimiters

    fun add(text: String?): Int {
        if (text.isNullOrBlank()) return 0
        val inputs = parseInputs(text)
        if (inputs.any { it.toInt() < 0 }) throw RuntimeException("Input must be non-negative")
        return addByInputSize(inputs)
    }

    private fun parseInputs(text: String): List<String> {
        var splitTarget = text
        if (text.startsWith("//")) {
            val delimiterAndInput = text.split("\n")
            val customDelimiter = delimiterAndInput[0].removePrefix("//")
            delimiters.add(customDelimiter)
            splitTarget = delimiterAndInput[1]
        }
        return splitTarget.split(delimiters = delimiters.toTypedArray())
    }

    private fun addByInputSize(inputs: List<String>): Int {
        assert(inputs.isNotEmpty())
        return when (inputs.size) {
            1 -> inputs[0].toInt()
            2 -> inputs[0].toInt() + inputs[1].toInt()
            else -> inputs[0].toInt() + inputs[1].toInt() + inputs[2].toInt()
        }
    }
}
