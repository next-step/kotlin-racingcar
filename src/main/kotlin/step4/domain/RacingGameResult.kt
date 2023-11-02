package step4.domain

class RacingGameResult {
    private val _racingResultList: MutableList<RacingCars> = mutableListOf()
    val racingResultList: List<RacingCars> get() = _racingResultList

    fun saveRacingResult(cars: RacingCars) {
        _racingResultList.add(cars)
    }
}
