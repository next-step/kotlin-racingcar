package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.service.CarMoveForwardDecider
import racingcar.service.CarMoveForwardFixedValueGetter

class CarsTest {

    @Test
    fun `2대 중 우승자가 1대인 경주 테스트`() {
        val cars = Cars.from(CarNames(listOf(CarName.from("a"), CarName.from("b"))))

        val car1 = cars.getCar(0)
        moveForward(car1)

        assertThat(cars.getWinners()).isNotNull
        assertThat(cars.getWinners().size).isEqualTo(1)
        assertThat(cars.getWinners()[0]).isEqualTo(car1)
        assertThat(cars.getWinners()[0].position).isEqualTo(1)
    }

    @Test
    fun `2대 중 우승자가 2대인 경주 테스트`() {
        val cars = Cars.from(CarNames(listOf(CarName.from("a"), CarName.from("b"))))

        val car1 = cars.getCar(0)
        moveForward(car1)

        val car2 = cars.getCar(1)
        moveForward(car2)

        assertThat(cars.getWinners()).isNotNull
        assertThat(cars.getWinners().size).isEqualTo(2)
        assertThat(cars.getWinners()[0]).isEqualTo(car1)
        assertThat(cars.getWinners()[0].position).isEqualTo(1)
        assertThat(cars.getWinners()[1]).isEqualTo(car2)
        assertThat(cars.getWinners()[1].position).isEqualTo(1)
    }

    @Test
    fun `3대 중 우승자가 1대인 경주 테스트`() {
        val cars = Cars.from(CarNames(listOf(CarName.from("a"), CarName.from("b"), CarName.from("c"))))

        val car1 = cars.getCar(0)
        moveForward(car1)
        moveForward(car1)

        val car2 = cars.getCar(1)
        moveForward(car2)

        assertThat(cars.getWinners()).isNotNull
        assertThat(cars.getWinners().size).isEqualTo(1)
        assertThat(cars.getWinners()[0]).isEqualTo(car1)
        assertThat(cars.getWinners()[0].position).isEqualTo(2)
    }

    @Test
    fun `3대 중 우승자가 2대인 경주 테스트`() {
        val cars = Cars.from(CarNames(listOf(CarName.from("a"), CarName.from("b"), CarName.from("c"))))

        val car1 = cars.getCar(0)
        moveForward(car1)

        val car2 = cars.getCar(1)
        moveForward(car2)

        assertThat(cars.getWinners()).isNotNull
        assertThat(cars.getWinners().size).isEqualTo(2)
        assertThat(cars.getWinners()[0]).isEqualTo(car1)
        assertThat(cars.getWinners()[0].position).isEqualTo(1)
        assertThat(cars.getWinners()[1]).isEqualTo(car2)
        assertThat(cars.getWinners()[1].position).isEqualTo(1)
    }

    @Test
    fun `3대 중 우승자가 3대인 경주 테스트`() {
        val cars = Cars.from(CarNames(listOf(CarName.from("a"), CarName.from("b"), CarName.from("c"))))

        val car1 = cars.getCar(0)
        moveForward(car1)

        val car2 = cars.getCar(1)
        moveForward(car2)

        val car3 = cars.getCar(2)
        moveForward(car3)

        assertThat(cars.getWinners()).isNotNull
        assertThat(cars.getWinners().size).isEqualTo(3)
        assertThat(cars.getWinners()[0]).isEqualTo(car1)
        assertThat(cars.getWinners()[0].position).isEqualTo(1)
        assertThat(cars.getWinners()[1]).isEqualTo(car2)
        assertThat(cars.getWinners()[1].position).isEqualTo(1)
        assertThat(cars.getWinners()[2]).isEqualTo(car3)
        assertThat(cars.getWinners()[2].position).isEqualTo(1)
    }

    private fun moveForward(winner: Car) {
        winner.moveForward(CarMoveForwardDecider(CarMoveForwardFixedValueGetter(4)))
    }
}
