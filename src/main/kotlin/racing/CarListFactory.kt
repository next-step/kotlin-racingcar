package racing

object CarListFactory {

    private const val DELIMITERS = ','

    fun createPlayCarList(inputData: String): PlayCarList {
        val carList = mutableListOf<Car>()
        val carNameList = splitInputData(inputData)

        carNameList.forEach { carList.add(Car(it)) }

        return PlayCarList(carList)
    }

    private fun splitInputData(inputData: String): List<String> {
        return inputData.split(DELIMITERS).map { it.trim() }
    }
}
