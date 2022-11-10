package racingcar.const

enum class MoveConditionType(val description: String) {
    RANDOM("랜덤 값을 기준으로 움직임을 제어한다."),
    NOT_MOVE("움직이지 않는다."),
    ALWAYS_MOVE("항상 움직인다."),
    TEST("테스트용이라 항상 움직인다.")
}
