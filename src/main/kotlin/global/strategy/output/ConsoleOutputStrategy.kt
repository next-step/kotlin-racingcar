package global.strategy.output

class ConsoleOutputStrategy : OutputStrategy {
    override fun execute(result: String) = println("연산 결과 : $result")
}
