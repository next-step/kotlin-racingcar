package calculator

private typealias OperatorPair = Pair<IntArithmetics, Int>

class Calculator(private val input: String) {
    fun calculate(): Int {
        val list = input.split(" ")
        val identity = list[0].toInt()
        return list.subList(1, list.size)
            .chunked(2)
            .map { chunk2Pair(it) }
            .fold(identity) { acc, curr -> accumulate(acc, curr) }
    }

    private fun chunk2Pair(it: List<String>): OperatorPair {
        val arithmetic = IntArithmetics.from(it[0])
        val number = it[1].toInt()
        return Pair(arithmetic, number)
    }

    private fun accumulate(acc: Int, curr: OperatorPair): Int {
        val arithmetic = curr.first
        val number = curr.second
        return arithmetic.apply(acc, number)
    }
}
