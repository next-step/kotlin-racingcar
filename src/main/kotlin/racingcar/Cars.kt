package racingcar

data class Cars(val cars: List<Car>) {

    fun move(moveStrategy: MoveStrategy): Cars {
        val newCars = cars.map { it.move(moveStrategy.isMove()) }
        return Cars(newCars)
    }
}
