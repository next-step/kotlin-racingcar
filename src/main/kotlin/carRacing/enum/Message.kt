package carRacing.enum

enum class Message(val code: Int, val message: String) {
    CAR_COUNT_QUESTION(1000, "자동차 대수는 몇 대 인가요?"),
    TRY_COUNT_QUESTION(1001, "시도할 회수는 몇 회 인가요?"),
}
