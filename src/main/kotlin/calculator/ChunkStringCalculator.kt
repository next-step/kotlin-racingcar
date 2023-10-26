package calculator

class ChunkStringCalculator(wholeElements: List<String>) {
    val calculationDeque = ArrayDeque<String>()

    init {
        wholeElements.forEach {
            calculationDeque.addFirst(it)
        }
    }

    fun chunk(wholeElements: List<String>): List<String> {
        TODO("chunk elements which have valid format for operation")
    }

    fun calculate(chunkElements: List<String>): String {
        TODO("calculate based on operator. converting string to int is needed")
    }

    fun isCalculationStopped(chunkElements: List<String>): Boolean {
        TODO("stop calculate if no element exists")
    }
}