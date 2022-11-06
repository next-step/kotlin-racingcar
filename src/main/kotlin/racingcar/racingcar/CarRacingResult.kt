package racingcar.racingcar

class CarRacingResult {
    private val results: MutableList<List<String>> = mutableListOf()

    fun record(result: List<String>) {
        results.add(result)
    }

    fun getAll(): List<List<String>> {
        return results
    }
}
