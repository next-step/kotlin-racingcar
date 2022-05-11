package carRacing

interface CarRacingManager {
    val cars: List<Car>

    fun addCar(car: Car)
    fun syncCarDistance(carsIndex: Int, carDistance: Int)
    fun getMonitoringInformation(): String
    fun validate()
}