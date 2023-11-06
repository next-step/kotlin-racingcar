package racing.car

import racing.rule.RuleInterface

class CarManager(private val rule: RuleInterface) {
    private val carList = mutableListOf<Car>()

    fun getCarList(): List<Car> {
        return carList
    }

    fun moveCar() {
        carList.forEach { if (rule.isMove()) it.move() }
    }

    fun createCarList(inputData: String) {
        val carNameList = splitInputData(inputData)
        carNameList.forEach { carList.add(Car(it)) }
    }

    fun validateCarList() {
        carList.map { it.validate() }
    }

    private fun splitInputData(inputData: String): List<String> {
        return inputData.split(DELIMITERS).map { it.trim() }
    }

    companion object {
        private const val DELIMITERS = ','
    }
}
