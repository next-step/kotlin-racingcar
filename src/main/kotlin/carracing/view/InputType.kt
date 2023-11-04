package carracing.view

enum class InputType(val question: String) {
    CAR_COUNT("자동차 대수는 몇 대인가요?"),
    RACING_COUNT("시도할 횟수는 몇 회인가요?"),
    RACING_NAMES("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."),
}
