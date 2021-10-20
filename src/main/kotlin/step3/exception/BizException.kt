package step3.exception

import step3.exception.message.Message

sealed class BizException(message: String) : RuntimeException(message) {
    class InputException(inputErrorMessage: Message) : BizException(inputErrorMessage.message)
}
