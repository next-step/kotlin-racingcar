package carracing.domain

import carracing.Car
import carracing.CarRacingException
import java.util.regex.Pattern

private const val MAX_NAME_LENGTH: Int = 5

class CarRacing(carNames: String = "test", private val count: Int) {

    private var cars: MutableList<Car> = mutableListOf()
    private var racingCount = 0;

    init {
        parsingCarNames(carNames)
    }

    private fun moveOrStop(car: Car?) {
        if (car == null) throw NullPointerException("자동차 이름을 입력해주세요.")
        car.move()
    }

    fun race(): List<Car> {
        cars.forEach { moveOrStop(it) }
        racingCount++
        return cars
    }

    fun isRacing(): Boolean = count >= racingCount

    private fun parsingCarNames(carNames: String) {
        if (carNames.isBlank()) {
            throw NullPointerException("자동차 이름을 입력해주세요.")
        }
        val pattern = Pattern.compile("^[a-z|A-Z][a-z|A-Z|,]*[a-z|A-Z]$")
        require(pattern.matcher(carNames).matches()) {
            "영문명과 구분자 쉼표 이외의 값은 입력할 수 없습니다."
        }
        carNames.split(",").forEach {
            cars.add(Car(it))
        }
        cars.forEach {
            if (it.name.length > MAX_NAME_LENGTH) throw CarRacingException("자동차명은 $MAX_NAME_LENGTH 자를 넘을 수 없습니다.")
        }
    }

    private fun getMaxPosition(): Int = cars.maxBy { it.position }?.position ?: 0

    fun findWinners(): List<Car> {
        val maxPosition = getMaxPosition()
        return cars.filter { it.isLocated(maxPosition) }
    }
}
