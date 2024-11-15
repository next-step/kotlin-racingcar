package racing

import org.jetbrains.annotations.TestOnly

class RaceResult {
    private val results = mutableListOf<Result>()

    fun add(result: Result) {
        results.add(result)
    }

    fun getResults(): List<Result> {
        return results.toList()
    }

    @TestOnly
    fun getRoundCount(): Int {
        return results.map(Result::round).distinct().size
    }

    @TestOnly
    fun getCarCount(): Int {
        return results.map(Result::carId).distinct().size
    }
}
