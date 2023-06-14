package calculator

object StringCalculatorUtility {

    fun calculate(target: String?, delimiter: String = " "): Int {
        require(!target.isNullOrBlank()) { "calculated string must not be null or blank. input(`$this`)" }
        return NumberOperationStrings(target.split(delimiter)).calculatedNumber
    }
}
