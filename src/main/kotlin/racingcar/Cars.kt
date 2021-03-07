package racingcar

class Cars(val cars:List<Car>) {
    fun winner(): List<Car> {
        val sortedCarsByPosition: List<Car> = cars.sortedByDescending { it.position }
        return sortedCarsByPosition.dropLastWhile { it.position < sortedCarsByPosition[0].position }
    }
}