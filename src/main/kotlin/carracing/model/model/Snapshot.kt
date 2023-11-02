package carracing.model.model

data class Snapshot(private val carTraces: List<CarTrace>) {

    init {
        require(carTraces.isNotEmpty()) { "'carTraces' should not be an empty list" }
    }

    override fun toString(): String {
        return carTraces.joinToString(separator = "\n", postfix = "\n")
    }
}
