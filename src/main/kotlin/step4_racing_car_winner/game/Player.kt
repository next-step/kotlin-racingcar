package step4_racing_car_winner.game

object Player {
    val cars = ArrayList<Car>()

    fun register(nameOfCars: String) {
        val carList = nameOfCars.split(",")
        for (name in carList) {
            require(isValidName(name)) { "자동차 이름은 5자를 초과할 수 없습니다." }
            cars.add(Car(name))
        }
    }

    private fun isValidName(name: String): Boolean {
        return name.length < 6
    }
}
