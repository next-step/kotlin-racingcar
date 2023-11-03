package game.view

class ConsoleInputWrapper : InputWrapper {
    override fun readlnOrNull(): String? {
        return kotlin.io.readlnOrNull()
    }
}
