package racingcar.common

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

    fun namedCarValidation(input: String?): List<String> {
        require(!input.isNullOrBlank()) {
            throw ExceptionCode.NotAllowNullOrBlank
        }

        require(input.matches(Regex("(.*),(.*)"))) {
            throw ExceptionCode.NotFindSeparator
        }

        return input.split(",")
    }
}
