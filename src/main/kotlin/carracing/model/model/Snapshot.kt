package carracing.model.model

data class Snapshot(val carTraces: List<CarTrace>) {
    override fun toString(): String {
        return carTraces.joinToString(separator = "\n", postfix = "\n")
    }
}
