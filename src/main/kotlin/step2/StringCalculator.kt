package step2

class StringCalculator {
    companion object {
        fun execute(input: String?): Int {
            InputValidator.validate(input)
            return Calculator.calculate(input!!)
        }
    }
}