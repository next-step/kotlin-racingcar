package global.strategy.split

@FunctionalInterface
fun interface SplitStrategy {
    fun split(target: String): List<String>
}
