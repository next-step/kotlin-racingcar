package step4.domain

class Game(
    nameOfCars: List<String>,
    private val numberOfTrials: Int,
) {
    private val cars: List<Car>
    private val gameLogs: MutableList<List<CarDto>> = mutableListOf()
    private val isPlayed: Boolean
        get() = gameLogs.isNotEmpty()

    init {
        require(nameOfCars.isNotEmpty()) { "자동차는 1대 이상이어야 합니다." }
        require(numberOfTrials > 0) { "시도 횟수는 1회 이상이어야 합니다." }

        cars = nameOfCars.map { Car(it.trim()) }
    }

    fun process() {
        repeat(numberOfTrials) {
            gameLogs.add(doProcess())
        }
    }

    private fun doProcess(): List<CarDto> {
        cars.forEach { it.moveForwardRandomly() }

        return cars.map { CarDto.of(it) }
    }

    fun getWinners(): List<CarDto> {
        check(isPlayed) { "게임이 진행되지 않았습니다." }

        val longestPosition = cars.maxByOrNull { it.position }!!.position

        return cars
            .filter { it.position == longestPosition }
            .map { CarDto.of(it) }
    }

    fun getGameLogs(): List<List<CarDto>> {
        check(isPlayed) { "게임이 진행되지 않았습니다." }

        return gameLogs
    }
}
