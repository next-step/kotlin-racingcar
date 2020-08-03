package carracing

private const val MAX_NAME_LENGTH: Int = 5

class CarRacing(carNames: String, private val count: Int) {
    private var cars: MutableList<Car> = mutableListOf()
    private var racingCount = 0;

    init {
        parsingCarNames(carNames)
    }

    constructor(listOf: List<Car>) : this("test", 0) {
        cars = listOf.toMutableList()
    }

    private fun moveOrStop(car: Car?) {
        if (car == null) throw NullPointerException("자동차 이름을 입력해주세요.")
        car.move()
    }

    fun race(): MutableList<Car> {
        cars.forEach { moveOrStop(it) }
        racingCount++
        return cars
    }

    fun isRacing(): Boolean = count >= racingCount

    private fun parsingCarNames(carNames: String?) {
        if (carNames.isNullOrBlank()) {
            throw NullPointerException("자동차 이름을 입력해주세요.")
        }
        require(carNames.matches(Regex("[a-z|A-Z|,]*"))) {
            "영문명과 구분자 쉼표 이외의 값은 입력할 수 없습니다."
        }
        require(!carNames.endsWith(",")) {
            "쉼표는 자동차 이름 사이에만 위치할 수 있습니다."
        }
        carNames.split(",").forEach {
            cars.add(Car(it))
        }
        cars.forEach {
            if (it.name.length > MAX_NAME_LENGTH) throw CarRacingException("자동차명은 $MAX_NAME_LENGTH 자를 넘을 수 없습니다.")
        }
    }

    fun getMaxPosition(): Int = cars.maxBy { it.position }?.position ?: 0

    fun findWinners(): List<Car> {
        val maxPosition = getMaxPosition()
        return cars.filter { it.isLocated(maxPosition) }
    }
}
