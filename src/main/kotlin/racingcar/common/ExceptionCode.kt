package racingcar.common

sealed class ExceptionCode {
    object NotAllowNullOrBlank : IllegalArgumentException("Input에 Null이나 빈 값이 있으면 안됩니다")
    object NotMatchNumeric : IllegalArgumentException("Input이 숫자가 아닙니다")
    object NotFindSeparator : IllegalArgumentException("Input에 구분자 ,가 없습니다")
    object NotExceedLengthCarName : IllegalArgumentException("자동차 이름은 5자를 넘을 수 없어요")
}
