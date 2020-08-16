package onestep.racingcar.domain

class Racing(
    carNames: List<String>,
    private val tryCount: Int,
    private val cars: Cars = carNames.toCars()
) {

    fun race(show: (Cars) -> Unit): Cars {
        repeat(tryCount) {
            cars.run()
            show(cars)
        }
        return cars.findWinners()
    }
}
