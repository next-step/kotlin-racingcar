package carRacing.enum

enum class Message(val code: Int, val message: String) {
    CAR_COUNT_QUESTION(1000, "자동차 대수는 몇 대 인가요?"),
    TRY_COUNT_QUESTION(1001, "시도할 회수는 몇 회 인가요?"),
    CAR_NAME_QUESTION(1002, "자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    RESULT(2000, "실행 결과"),
}
