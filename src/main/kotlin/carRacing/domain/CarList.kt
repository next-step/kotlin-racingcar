package carRacing.domain

data class CarList(private val carList: MutableList<Car> = mutableListOf()) {
    fun add(car: Car) {
        this.carList.add(car)
    }

    fun addAll(inputCarList: List<Car>) {
        inputCarList.forEach(::add)
    }

    fun getCarList(): List<Car> = this.carList.toList()
}
