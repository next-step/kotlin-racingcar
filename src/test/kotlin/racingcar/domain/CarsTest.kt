package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CarsTest {
    lateinit var cars: Cars

    @Test
    @DisplayName("값이 4이상인 자동차들만 전진시킨다")
    fun move() {
        // given

        // when
        cars.move()

        // then
        assertThat(cars.getCars()[0].position.position).isEqualTo(1)
        assertThat(cars.getCars()[1].position.position).isEqualTo(1)
        assertThat(cars.getCars()[2].position.position).isEqualTo(0)
    }

    @Test
    @DisplayName("값이 4이상인 자동차들만 반복 전진시킨다")
    fun moveRepeatedly() {
        // given
        // when
        cars.move(3)

        // then
        assertThat(cars.getCars()[0].position.position).isEqualTo(3)
        assertThat(cars.getCars()[1].position.position).isEqualTo(3)
        assertThat(cars.getCars()[2].position.position).isEqualTo(0)
    }

    @Test
    @DisplayName("자동차 리스트 중 최대 위치를 찾는다")
    fun getMaxPosition() {
        // given
        cars.move(1)

        // when
        val maxPosition = cars.getMaxPosition()

        // then
        assertThat(maxPosition.position).isEqualTo(1)
    }

    @Test
    @DisplayName("자동차 리스트에서 최대 위치를 찾을 때 자동차가 없으면 예외가 발생한다")
    fun getMaxPositionFailedEmptyCar() {
        // given
        val emptyCars = Cars(listOf())

        // when & then
        assertThatThrownBy { emptyCars.getMaxPosition() }
            .isInstanceOf(IllegalStateException::class.java)
            .hasMessage("자동차가 없습니다")
    }

    @Test
    @DisplayName("자동차 리스트에서 가장 큰 위치를 갖는 자동차 리스트를 반환한다")
    fun getWinners() {
        // given
        cars.move(1)

        // when
        val winners = cars.getWinners()

        // then
        assertThat(winners).hasSize(2)
        assertThat(winners).contains(cars.getCars()[0], cars.getCars()[1])
    }

    @BeforeEach
    fun setUp() {
        val car1 = Car(name = Name("car1"), movingStrategy = StubRandomMovingStrategy(4))
        val car2 = Car(name = Name("car2"), movingStrategy = StubRandomMovingStrategy(4))
        val car3 = Car(name = Name("car3"), movingStrategy = StubRandomMovingStrategy(3))
        cars = Cars(listOf(car1, car2, car3))
    }
}
