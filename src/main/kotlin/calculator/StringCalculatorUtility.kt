package calculator

class StringCalculatorUtility private constructor() {

    init {
        throw AssertionError("${javaClass.name} can not be initialized}")
    }

    companion object {
        fun String?.calculatedNumber(delimiter: String = " "): Int {
            require(!isNullOrBlank()) { "calculated string must not be null or blank. input(`$this`)" }
            return StingsCalculator(split(delimiter)).number
        }
    }
}
