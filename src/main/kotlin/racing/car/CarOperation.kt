package racing.car

interface CarOperation {
    fun getCarList(): List<Car>
    fun moveCar()
    fun createCarList(inputData: String)
    fun validateInputData(inputData: String)
}
