package racingCar.common

class InputValidation {
    fun validate(input: String?): Int {
        require(!input.isNullOrBlank()) {
            throw ExceptionCode.NotAllowNullOrBlank
        }

        require(input.matches(Regex("\\d+"))) {
            throw ExceptionCode.NotMatchNumeric
        }
        return input.toInt()
    }
}
