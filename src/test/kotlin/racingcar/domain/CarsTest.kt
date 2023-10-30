package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CarsTest {

    @Test
    @DisplayName("값이 4이상인 자동차들만 전진시킨다")
    fun move() {
        // given
        val car1 = Car(movingStrategy = StubRandomMovingStrategy(4))
        val car2 = Car(movingStrategy = StubRandomMovingStrategy(4))
        val car3 = Car(movingStrategy = StubRandomMovingStrategy(3))
        val cars = Cars(listOf(car1, car2, car3))

        // when
        cars.move()

        // then
        assertThat(cars.getCars()[0].getPosition()).isEqualTo(1)
        assertThat(cars.getCars()[1].getPosition()).isEqualTo(1)
        assertThat(cars.getCars()[2].getPosition()).isEqualTo(0)
    }

    @Test
    @DisplayName("값이 4이상인 자동차들만 반복 전진시킨다")
    fun moveRepeatedly() {
        // given
        val car1 = Car(movingStrategy = StubRandomMovingStrategy(4))
        val car2 = Car(movingStrategy = StubRandomMovingStrategy(4))
        val car3 = Car(movingStrategy = StubRandomMovingStrategy(3))
        val cars = Cars(listOf(car1, car2, car3))

        // when
        cars.move(3)

        // then
        assertThat(cars.getCars()[0].getPosition()).isEqualTo(3)
        assertThat(cars.getCars()[1].getPosition()).isEqualTo(3)
        assertThat(cars.getCars()[2].getPosition()).isEqualTo(0)
    }
}