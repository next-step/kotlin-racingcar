package carracing

import java.lang.NullPointerException

class CarRacing(carNames: String?) {
    private var cars: MutableList<Car> = mutableListOf()

    // init {
    //     parsingCarNames(carNames)
    // }
    //
    constructor(listOf: List<Car>) : this("test") {
        cars = listOf.toMutableList()
    }

    private fun generateRandomNumber(): Int = (0..9).random()

    fun moveOrStop(car: Car) {
        if (generateRandomNumber() > STANDARD_COUNT) car.move()
    }

    fun execute() {
    }

    private fun parsingCarNames(carNames: String?) {
        if (carNames.isNullOrBlank()) {
            throw NullPointerException("자동차 이름을 입력해주세요.")
        }
        if (!carNames.matches(Regex("[a-z|A-Z|,]*"))) {
            throw CarRacingException("영문명과 구분자 쉼표 이외의 값은 입력할 수 없습니다.")
        }
        if (carNames.endsWith(",")) {
            throw CarRacingException("쉼표는 자동차 이름 사이에만 위치할 수 있습니다.")
        }
        carNames.split(",").forEach {
            cars.add(Car(it))
        }
        cars.forEach {
            if (it.name.length > MAX_NAME_LENGTH) throw CarRacingException("자동차명은 $MAX_NAME_LENGTH 자를 넘을 수 없습니다.")
        }
    }

    private fun getMaxPosition(): Int = cars.maxBy { it.position }?.position ?: 0

    fun findWinners(): List<Car> = cars.filter { it.position == getMaxPosition() }

    companion object {
        const val STANDARD_COUNT: Int = 3
        const val MAX_NAME_LENGTH: Int = 5
    }
}
