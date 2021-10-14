package calculator.exception

class OperatorNotFoundException : IllegalArgumentException(VALIDATION_MESSAGE) {
    companion object {
        private const val VALIDATION_MESSAGE = "연산자를 찾을 수 없습니다. 다시 입력해주세요."
    }
}
