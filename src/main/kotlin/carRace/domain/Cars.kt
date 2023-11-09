package carRace.domain

data class Cars(val carList: List<Car>) {
    fun driveCars() {
        carList.forEach {
            it.drive()
        }
    }
}
