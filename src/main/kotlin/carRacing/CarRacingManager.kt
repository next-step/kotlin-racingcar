package carRacing

interface CarRacingManager {
    var cars: List<Car>

    fun addCar(car: Car)
    fun syncCarDistance(carsIndex: Int)
    fun getMonitoringInformation(): String
}