package racinggame

object Dice {
    fun pitch(strategy: () -> Int): Int {
        return strategy.invoke() % 10
    }
}
