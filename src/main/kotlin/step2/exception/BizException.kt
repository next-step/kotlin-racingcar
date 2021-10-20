package step2.exception

import step2.exception.message.Message

sealed class BizException(message: String) : IllegalArgumentException(message) {
    class CustomException(calculatorMessage: Message) : BizException(calculatorMessage.message)
}
