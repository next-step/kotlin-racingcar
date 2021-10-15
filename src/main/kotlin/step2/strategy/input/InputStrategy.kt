package step2.strategy.input

@FunctionalInterface
fun interface InputStrategy {
    fun execute(): String?
}