package racingcar

import printer.ResultView
import java.util.stream.IntStream
import kotlin.streams.toList

fun main() {
    val numberOfCars = Reception.receiveNumberOfCar()
    val numberOfAttempts = Reception.receiveNumberOfAttempts()

    // 자동차 댓수만큼 Car 를 생성한다.
    val cars = createCars(numberOfCars)

    val racingCar = RacingCars(cars)

    ResultView.printInt()

    racingCar.racing(numberOfAttempts)
}

private fun createCars(numberOfCar: Int): List<Car> {
    return IntStream.range(0, numberOfCar)
        .mapToObj { Car() }
        .toList()
}
