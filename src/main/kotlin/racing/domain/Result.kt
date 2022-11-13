package racing.domain

class Result {
    private val roundResults: MutableList<CarInfos> = mutableListOf()
    val carInfosList: List<CarInfos>
        get() = roundResults.toList()

    fun add(carInfos: CarInfos) {
        roundResults.add(carInfos)
    }
}
