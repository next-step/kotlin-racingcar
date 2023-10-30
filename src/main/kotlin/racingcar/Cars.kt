package racingcar

class Cars(carNames: List<String>) {

    var carList: List<Car>

    init {
        carList = initCar(carNames)
    }

    private fun initCar(carNames: List<String>): List<Car> {
        require(carNames.carNameCheck()) { "자동차 이름은 5자 이하만 가능합니다." }
        return carNames.map { carName ->
            Car(carName)
        }
    }

    fun operateCars(): Cars {
        carList = carList.map { car ->
            car.move(generate())
        }
        return this
    }

    fun isWinner(): List<String> {
        val maxPosition = carList.maxOf { it.position }
        return carList.filter { it.position == maxPosition }.map { it.carName }
    }

    private fun List<String>.carNameCheck(): Boolean {
        return this.all { it.length <= 5 }
    }
}
