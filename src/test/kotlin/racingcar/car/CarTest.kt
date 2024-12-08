package racingcar.car

import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `차를 2개 만들고 3번 움직인다`() {
        val tryCount = 3

        val cars = Cars()
        cars.addCar(Car())
        cars.addCar(Car())

        cars.iterator().forEach { car -> car.move(1) }

        for (x in 1..tryCount) {
            for (car in cars) {
                car.move(RandomMachine.getMovingNumber())
            }
            ResultView.printResult(cars)
        }
    }
}
