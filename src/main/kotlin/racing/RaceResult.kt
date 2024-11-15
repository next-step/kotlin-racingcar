package racing

class RaceResult {
    private val results = mutableListOf<Result>()

    fun add(result: Result) {
        results.add(result)
    }

    fun getResults(): List<Result> {
        return results.toList()
    }
}
