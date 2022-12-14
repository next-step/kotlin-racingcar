package racingcar.domain.model

class CarNames(private val carNameList: List<String>) {

    init {
        require(carNameList.isNotEmpty()) { "자동차 이름이 있어야 합니다" }
    }

    fun makeCars(): Cars {
        val carList = carNameList.map { name -> Car(CarName(name), Position(0)) }
        return Cars(carList)
    }

    fun joinToString(separator: String): String = carNameList.joinToString(separator)
}
