package racingcar.common

sealed class ExceptionCode {
    object NotAllowNullOrBlank : IllegalArgumentException("Input에 Null이나 빈 값이 있으면 안됩니다")
    object NotMatchNumeric : IllegalArgumentException("Input이 숫자가 아닙니다")
}
