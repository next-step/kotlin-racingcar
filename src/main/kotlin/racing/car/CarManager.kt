package racing.car

import racing.rule.RuleInterface

class CarManager(private val rule: RuleInterface) : CarOperation {
    private val carList = mutableListOf<Car>()

    override fun getCarList(): List<Car> {
        return carList
    }

    override fun moveCar() {
        carList.forEach { if (rule.isMove()) it.move() }
    }

    override fun createCarList(inputData: String) {
        val carNameList = splitInputData(inputData)
        carNameList.forEach { carList.add(Car(it)) }
    }

    override fun validateInputData(inputData: String) {
        val nameList = splitInputData(inputData)

        validateCarCnt(nameList)

        nameList.forEach {
            validateNameLength(it)
            validateEmpty(it)
        }

    }

    private fun splitInputData(inputData: String): List<String> {
        return inputData.split(DELIMITERS).map { it.trim() }
    }

    private fun validateNameLength(carName: String) {
        if (carName.length > 5) {
            throw IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.")
        }
    }

    private fun validateEmpty(carName: String) {
        // 공백을 입력했을 경우
        if (carName.isEmpty()) {
            throw IllegalArgumentException("자동차 이름이 공백입니다.")
        }
    }

    private fun validateCarCnt(nameList: List<String>) {
        // 자동차가
        if (nameList.size == 1 && nameList.first().isEmpty()) {
            throw IllegalArgumentException("출전할 자동차의 대수가 0 입니다.")
        }
    }

    companion object {
        private const val DELIMITERS = ','
    }
}
