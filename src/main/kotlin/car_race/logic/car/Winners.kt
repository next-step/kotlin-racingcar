package car_race.logic.car

data class Winners(
    private val cars: List<Car>
) {
    fun getResult(): String {
        return "${cars.joinToString { car ->
            car.carName.name
        }}가 최종 우승했습니다."
    }
}
