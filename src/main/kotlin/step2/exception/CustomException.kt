package step2.exception

class CustomException(errorMessage: ErrorMessage) : IllegalArgumentException(errorMessage.message) {
    override val message: String

    init {
        message = errorMessage.message
    }
}
