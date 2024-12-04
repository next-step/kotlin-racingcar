package racingcar.car

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `차를 3개 만들고 움직인다`() {
        val carCount = 3

        var cars = Cars()
        for (i in 1..carCount) {
            cars.addCar(Car())
        }
        assertThat(cars).hasSize(carCount)
    }

    @Test
    fun `차를 4개 만들고 3번 움직인다`() {
        val carCount = 4
        val tryCount = 3

        var cars = Cars()
        for (i in 1..carCount) {
            cars.addCar(Car())
        }

        for (x in 1..tryCount) {
            for (car in cars) {
                car.move(RandomMachine.getRandomNumber())
            }
            ResultView.printResult(cars)
        }
    }
}
