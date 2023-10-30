package step3_4_5.domain.racing

class CarRacing(
    private val carList: List<Car>,
    private val numberOfRounds: Int,
) {

    init {
        val carNameList = carList.map { it.carName }
        require(carNameList.count() == carNameList.toSet().count()) { error(DUPLICATE_ELEMENT_IS_EXIST) }
    }

    fun doRacing(showResult: (List<Car>) -> Unit) {
        repeat(numberOfRounds) {
            carList.forEach { car -> car.moveForward() }
            showResult(carList)
        }
    }

    companion object {
        private const val DUPLICATE_ELEMENT_IS_EXIST = "중복 요소가 존재 합니다"
    }
}
