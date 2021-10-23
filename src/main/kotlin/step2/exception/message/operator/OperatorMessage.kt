package step2.exception.message.operator

import step2.exception.message.Message

enum class OperatorMessage(override val message: String) : Message {
    NOT_OPERATOR("올바르지 않은 연산자입니다."),
    CAN_NOT_DIVIDED_BY_ZERO("0으로 나눌 수 없습니다.");
}
