package racingcar.ui

enum class MessageCode(val message: String) {
    CarNumberQuestion("자동차 대수는 몇 대 인가요?"),
    TryNumberQuestion("시도할 횟수는 몇 회 인가요?"),
    TryNumberException("시도 횟수의 형식이 맞지 않습니다."),
    CarNumberException("차량의 숫자 형식이 맞지 않습니다."),
    Result("실행 결과")
}
