package step2.strategy.input

class ConsoleInputStrategy : InputStrategy {
    override fun execute(): String? = readLine()
}