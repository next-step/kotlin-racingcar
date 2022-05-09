package step2.calculator

object StringCalculator {
    fun execute(input: String?): Int {
        InputValidator.validate(input)
        return Calculator.calculate(input!!)
    }
}
