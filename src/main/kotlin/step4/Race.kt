package step4

object Race {
    private const val carNameDelimiter = ","

    fun initiate(carNameList: String): List<Car> {
        val carNames = carNameList.split(carNameDelimiter)
        val carList = ArrayList<Car>()

        for (carName in carNames) {
            carList.add(Car(carName, emptyList()))
        }
        return carList
    }
}
