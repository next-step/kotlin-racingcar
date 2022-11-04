package calculator

class Memory(private var terms: List<String> = emptyList(), var accumulator: Int = 0) {

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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Memory

        if (terms != other.terms) return false
        if (accumulator != other.accumulator) return false

        return true
    }

    override fun hashCode(): Int {
        var result = terms.hashCode()
        result = 31 * result + accumulator
        return result
    }
}
