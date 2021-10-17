package global.strategy.input

class ConsoleInputStrategy : InputStrategy {
    override fun execute(): String? = readLine()
}
