package racingCar.domain

class RaceLog {
    var carsLog: MutableList<List<Car>> = mutableListOf()
    lateinit var winners: List<Car>

    fun addLog(carList: List<Car>) {
        carsLog += carList
    }
}