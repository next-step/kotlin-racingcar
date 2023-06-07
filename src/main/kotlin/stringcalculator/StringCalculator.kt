package stringcalculator

class StringCalculator {
    companion object {
        fun calculate(input: String?) {
            require(!input.isNullOrBlank())
            require(input.contains(Regex("[+\\-*/]")))
        }
    }
}
