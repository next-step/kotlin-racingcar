package global.strategy.input

@FunctionalInterface
fun interface InputStrategy {
    fun execute(): String?
}
