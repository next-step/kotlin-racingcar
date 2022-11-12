package study.step4.model

import study.step4.view.InputValid

const val CAR_NAME_DELIMITERS = ","

class RacingGame(
    racingCarNames: String,
    private val repeatNumber: Int,
    private val digitGenerator: DigitGenerator = RandomDigit(),
    private val cars: MutableList<Car> = mutableListOf()
) {

    init {
        val carNamesList = carNamesList(racingCarNames)
        InputValid.racingCarNameValid(carNamesList)
        settingCar(carNamesList)
    }

    private fun settingCar(numberCar: List<String>) {
        numberCar.forEach { name ->
            cars.add(Car(name = name, engin = DigitEngine(digitGenerator)))
        }
    }

    fun race() {
        repeat(repeatNumber) {
            processRace()
        }
    }

    private fun processRace() {
        cars.forEach { car: Car ->
            car.move()
        }
    }

    fun getCars(): List<Car> = cars.toList()

    fun getChampions(): List<Car> {
        val maxLocation = cars.maxOf { it.getLocation() }
        return cars.filter { it.getLocation() == maxLocation }.toList()
    }

    private fun carNamesList(racingCarNames: String): List<String> =
        racingCarNames.split(CAR_NAME_DELIMITERS)
            .map { it.trim() }
            .filter { it.isNotEmpty() }
            .toList()
}
