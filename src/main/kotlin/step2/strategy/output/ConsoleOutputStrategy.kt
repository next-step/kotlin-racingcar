package step2.strategy.output

class ConsoleOutputStrategy : OutputStrategy {
    override fun execute(result: String) = println(result)
}