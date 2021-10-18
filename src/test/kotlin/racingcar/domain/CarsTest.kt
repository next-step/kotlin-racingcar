package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CarsTest {

    @Test
    fun `요청한 이름만큼 자동차를 생성한다`() {
        val names = "a,b,c,d,e"

        val actual = Cars.createCars(Names.generateNames(names))

        assertThat(actual.cars).hasSize(5)
    }

    @Test
    fun `자동차 목록을 이동하면 변경된 자동차 목록을 리턴한다`() {
        // given
        val cars = Cars(listOf(Car(Name("a")), Car(Name("b"))))

        val actual = cars.move()

        assertThat(actual).isNotSameAs(cars)
    }

    @Test
    fun `가장 멀리간 우승자를 리턴한다`() {
        // given
        val car1 = Car(Name("a"), Position(1))
        val car2 = Car(Name("b"), Position(3))
        val givenCars = Cars(listOf(car1, car2))

        // when
        val winners = givenCars.findWinners()

        // then
        assertThat(winners.cars).containsExactly(car2)
    }

    @Test
    fun `우승자가 두대 이상인 경우의 우승자 목록을 리턴한다`() {
        // given
        val car1 = Car(Name("a"), Position(1))
        val car2 = Car(Name("b"), Position(3))
        val car3 = Car(Name("c"), Position(3))
        val givenCars = Cars(listOf(car1, car2, car3))

        // when
        val winners = givenCars.findWinners()

        // then
        assertThat(winners.cars).containsExactly(car2, car3)
    }
}
