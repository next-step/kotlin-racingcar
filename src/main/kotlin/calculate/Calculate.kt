package calculate

class Calculate(var validations: List<CalculateValidation>) {

    constructor() : this(listOf(EmptyCheckValidation()))

    fun calculate(input: String): Int {
        validate(input)
        var result = 0
        val numbers = input.split("+")
        for (number in numbers) {
            result += number.toInt()
        }
        return result
    }

    private fun validate(input: String) {
        validations.forEach {
            it.validate(input)
        }
    }
}
