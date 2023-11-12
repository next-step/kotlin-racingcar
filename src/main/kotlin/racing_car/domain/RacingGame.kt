package racing_car.domain

class RacingGame(
    private val cars: List<Car>,
    racingRound: Int,
) {
    private val roundInfo: RoundInfo = RoundInfo(totalRound = racingRound)

    init {
        require(cars.size >= 2) { "경주에 필요한 자동차 대수는 2대 이상입니다." }
    }

    val carInfos: List<CarInfo>
        get() = cars.map { it.carInfo }

    val isContinuable: Boolean
        get() = roundInfo.isContinuable

    val isFinish: Boolean
        get() = roundInfo.isFinish

    fun move() {
        check(isContinuable) { "시도회수를 초과하였습니다." }
        cars.forEach(Car::move)
        roundInfo.increaseCurrentRound()
    }

    fun judgeWinners(): List<String> {
        check(isFinish) { "아직 경주가 끝나지 않았습니다." }

        val winners = cars.filter { car ->
            cars.all { otherCar ->
                car.isWin(otherCar) || car.isDraw(otherCar)
            }
        }

        return winners.map(Car::name)
    }
}
