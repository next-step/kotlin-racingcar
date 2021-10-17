package global.strategy.output

@FunctionalInterface
interface OutputStrategy {
    fun execute(result: String)
}
