package racing.domain

class Result {
    val roundResults: MutableList<Cars> = mutableListOf()

    fun add(cars: Cars) {
        roundResults.add(cars)
    }
}
