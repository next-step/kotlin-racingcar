package calculator

data class Memory(private var terms: List<String> = emptyList(), private var _accumulator: Int = 0) {

    val accumulator
        get() = _accumulator

    fun store(terms: List<String>) {
        this.terms = terms
        this._accumulator = terms[0].toInt()
    }

    fun accumulate(value: Int) {
        _accumulator = value
    }

    fun size(): Int {
        return terms.size
    }

    fun fetch(address: Int): String {
        return terms[address]
    }

    fun reset() {
        terms = emptyList()
        _accumulator = 0
    }
}
