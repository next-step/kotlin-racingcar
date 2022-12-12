package racingcar.domain.model

class Cars(private val carList: List<Car> = emptyList()) {

    init {
        require(carList.isNotEmpty()) { "자동차 경주자가 있어야 합니다." }
    }

    fun findWinner(): Cars {
        val max: Int = carList.maxOf { car -> car.position }
        val winnerList = carList.filter { car -> car.position == max }
        return Cars(winnerList)
    }

    fun names(): List<String> {
        return carList.map { car -> car.carName.name }
    }

    fun race() {
        carList.forEach { racer ->
            racer.moveTo(count = (0..9).random())
        }
    }

    fun copy(): Cars {
        val carRacerList = carList.map { car -> car.copy() }
        return Cars(carRacerList)
    }

    fun forEach(eachAction: (Car) -> Unit) {
        carList.forEach(eachAction)
    }
}
