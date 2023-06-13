package racinggame.view

enum class RacingGameFixedMessage(
    val koreaGuideMessage: String
) {

    PARTICIPANTS_INPUT("자동차 대수는 몇 대인가요?"),
    GAME_PLAY_COUNT_INPUT("시도할 횟수는 몇 회인가요?"),
    FINISH_WITH_NOT_POSITIVE_INTEGER("양의 정수를 입력하지 않아 프로그램을 종료합니다."),
    BLANK(""),
    EXECUTE_RESULT("실행 결과"),
}
