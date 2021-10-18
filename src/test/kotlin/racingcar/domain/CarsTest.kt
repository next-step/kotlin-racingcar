package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CarsTest {

    @Test
    fun `요청한 이름만큼 자동차를 생성한다`() {
        val names = "a,b,c,d,e"

        val actual = Cars.createCars(Names.generateNames(names))

        assertThat(actual.size()).isEqualTo(5)
    }

    @Test
    fun `자동차 목록을 이동하면 변경된 자동차 목록을 리턴한다`() {
        // given
        val cars = Cars(listOf(Car(Name("a")), Car(Name("b"))))

        val actual = cars.move()

        assertThat(actual).isNotSameAs(cars)
    }
}
