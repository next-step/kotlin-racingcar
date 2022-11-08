package racingcar.domain

class Car {
    companion object {
        fun registerCars(numberOfCars: Int): Array<Car> {
            require(numberOfCars != 0) { "0대의 차로는 시작할 수 없습니다." }
            return Array(numberOfCars) { Car() }
        }
    }
}
