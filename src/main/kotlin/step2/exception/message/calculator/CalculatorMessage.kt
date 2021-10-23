package step2.exception.message.calculator

import step2.exception.message.Message

enum class CalculatorMessage(override val message: String) : Message {

    NULL_AND_EMPTY("입력값이 비어있거나 NULL 일 수 없습니다."),
}
