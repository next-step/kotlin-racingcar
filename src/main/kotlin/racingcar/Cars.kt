package racingcar

data class Cars(val cars: List<Car>) {

    fun move(moveStrategy: MoveStrategy): Cars {
        val newCars = mutableListOf<Car>()
        cars.forEach { newCars.add(it.move(moveStrategy.isMove())) }
        return Cars(newCars)
    }
}
