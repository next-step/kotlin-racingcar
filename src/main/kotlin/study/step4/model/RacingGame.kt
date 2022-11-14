package study.step4.model

import study.step4.model.RacingCarNameGenerator.racingCarNameValid

class RacingGame(
    racingCarNames: List<String>,
    private val repeatNumber: Int,
    private val digitGenerator: DigitGenerator = RandomDigit(),
    private val cars: MutableList<Car> = mutableListOf()
) {

    init {
        racingCarNameValid(racingCarNames)
        settingCar(racingCarNames)
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
}
