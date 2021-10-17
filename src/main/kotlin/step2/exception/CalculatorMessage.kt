package step2.exception

enum class CalculatorMessage(override val message: String) : ErrorMessage {

    NULL_AND_EMPTY("입력값이 비어있거나 NULL 일 수 없습니다."),
    NOT_OPERATOR("올바르지 않은 연산자입니다."),
    CAN_NOT_DIVIDED_BY_ZERO("0으로 나눌 수 없습니다.");
}
