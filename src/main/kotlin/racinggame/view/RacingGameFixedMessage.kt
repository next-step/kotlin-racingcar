package racinggame.view

enum class RacingGameFixedMessage(
    val koreaGuideMessage: String
) {

    CAR_NAMES_INPUT("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."),
    GAME_PLAY_COUNT_INPUT("시도할 횟수는 몇 회인가요?"),
    FINISH_WITH_INVALID_NAME("자동차 이름은 공백이 될 수 없고, 최대 5자를 초과할 수 없습니다."),
    FINISH_WITH_NOT_POSITIVE_INTEGER("양의 정수를 입력하지 않아 프로그램을 종료합니다."),
    BLANK(""),
    EXECUTE_RESULT("실행 결과"),
}
