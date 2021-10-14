package stringcalculator.operations

interface Operation {
    fun execute(deque: ArrayDeque<Int>)

    @Throws(NoSuchElementException::class)
    fun popFirstTwo(deque: ArrayDeque<Int>): Pair<Int, Int> {
        val arg1 = deque.removeFirst()
        val arg2 = deque.removeFirst()
        return Pair(arg1, arg2)
    }
}
