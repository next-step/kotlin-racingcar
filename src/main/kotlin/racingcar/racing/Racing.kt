package racingcar.racing

import racingcar.car.Car
import racingcar.view.OutputView.resultView
import java.util.stream.Collectors

object Racing {
    fun racingStart(carCount: Int, tryCount: Int) {
        val cars = initCars(carCount)
        resultView(cars, tryCount)
    }

    fun initCars(carCount: Int): List<Car> =
        (1..carCount).map(::Car)

    fun moveCarForward(cars: List<Car>): List<Car> {
        return cars.stream().peek(Car::move).collect(Collectors.toList())
    }
}
