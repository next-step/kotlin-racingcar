package wk1_step4

object WinnerCarRacing {

    private fun moveOrStop(car: Car) {
        val number: Int = ((Math.random() * 10).toInt())
        if (number > 3) car.position = car.position + 1
    }

    fun updateCarRacing(cars: List<Car>) {
        if (cars.isEmpty()) {
            throw WinnerCarRacingException("자동차 이름을 입력하세요.")
        }
        for (car in cars) {
            moveOrStop(car)
        }
    }
}
