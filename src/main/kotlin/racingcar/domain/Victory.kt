package racingcar.domain

object Victory {
    fun victoryCar(carList: List<Car>): List<Car> {
        val max = carList.maxOf { it.distance }
        return carList.filter { it.distance == max }.toList()
    }
}
