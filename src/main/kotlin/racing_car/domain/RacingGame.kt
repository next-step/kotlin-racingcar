package racing_car.domain

class RacingGame(
    private val cars: List<Car>,
    private val racingRound: Int,
) {
    private var currentRacingRound: Int = 0

    init {
        require(cars.size >= 2) { "경주에 필요한 자동차 대수는 2대 이상입니다." }
        require(racingRound >= 1) { "경주는 1번 이상 시도되어야합니다." }
    }

    val carInfos: List<CarInfo>
        get() = cars.map { it.carInfo }

    val isContinuable: Boolean
        get() = currentRacingRound < racingRound

    val isFinish: Boolean
        get() = !isContinuable

    fun move() {
        check(currentRacingRound < racingRound) { "시도회수를 초과하였습니다." }
        cars.forEach(Car::move)
        currentRacingRound++
    }

    fun judgeWinners(): List<String> {
        check(isFinish) { "아직 경주가 끝나지 않았습니다." }
        val winningPosition = cars.maxOf { it.position }
        return cars.filter { it.position == winningPosition }.map(Car::name)
    }
}
