package stringcalculator.operations

class Add : Operation {
    override fun execute(deque: ArrayDeque<Int>) {
        val (arg1, arg2) = popFirstTwo(deque)
        deque.addFirst(arg1 + arg2)
    }
}
