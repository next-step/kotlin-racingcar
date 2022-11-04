package calculator

data class Memory(private var terms: List<String> = emptyList(), var accumulator: Int = 0) {

    fun store(terms: List<String>) {
        this.terms = terms
        this.accumulator = terms[0].toInt()
    }

    fun size(): Int {
        return terms.size
    }

    fun fetch(address: Int): String {
        return terms[address]
    }

    fun reset() {
        terms = emptyList()
        accumulator = 0
    }
}
