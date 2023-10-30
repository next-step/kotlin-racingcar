package game

class ConsoleInputWrapper : InputWrapper {
    override fun readlnOrNull(): String? {
        return kotlin.io.readlnOrNull()
    }
}
