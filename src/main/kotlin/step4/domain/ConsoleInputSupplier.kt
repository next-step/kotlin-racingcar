package step4.domain

class ConsoleInputSupplier : InputSupplier {
    override fun read(): String {
        return readln()
    }
}
