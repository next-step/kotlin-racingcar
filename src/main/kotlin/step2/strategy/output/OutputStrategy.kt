package step2.strategy.output

@FunctionalInterface
interface OutputStrategy {
    fun execute(result: String)
}
