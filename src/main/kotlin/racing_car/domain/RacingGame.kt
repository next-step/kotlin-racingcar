package racing_car.domain

class RacingGame(
    cars: List<Car>,
    racingRound: Int,
) {
    private val roundInfo: RoundInfo = RoundInfo(totalRound = racingRound)
    private val cars: Cars = Cars(cars)

    val isContinuable: Boolean
        get() = roundInfo.isContinuable

    fun getCarList(): List<Car> {
        return cars.cars
    }

    fun move() {
        check(roundInfo.isContinuable) { "시도회수를 초과하였습니다." }
        cars.moveAll()
        roundInfo.increaseCurrentRound()
    }

    fun judgeWinners(): List<Car> {
        check(roundInfo.isFinish) { "아직 경주가 끝나지 않았습니다." }
        return cars.getWinningCars()
    }
}
