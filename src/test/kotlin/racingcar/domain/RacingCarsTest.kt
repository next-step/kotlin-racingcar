package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import racingcar.domain.strategy.TestMovingStrategy

@DisplayName("간단한 자동차 콜렉션(SimpleRacingCars)")
class RacingCarsTest {
    @Test
    fun `자동차 리스트를 받아 일급 콜렉션을 생성한다`() {
        val cars = listOf(RacingCarFixture.STATIC_CAR, RacingCarFixture.MOVING_CAR)
        assertThat(RacingCars(cars).toList()).isEqualTo(cars)
    }

    @Test
    fun `자동차 리스트가 비어있으면 예외를 발생한다`() {
        assertThatThrownBy { RacingCars(emptyList()) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("한 대 이상의 자동차가 필요합니다.")
    }

    @Test
    fun `자동차들이 경주한다`() {
        val car1 = RacingCarFixture.MOVING_CAR
        val car2 = RacingCarFixture.STATIC_CAR
        val racingCars = RacingCars(listOf(car1, car2))
        val racingCarsMoved = racingCars.race()

        assertAll(
            { assertThat(racingCars).isNotEqualTo(racingCarsMoved) },
            { assertThat(racingCars.toList()).containsExactly(car1, car2) },
            { assertThat(racingCarsMoved.toList()).containsExactly(car1.moved(), car2.moved()) }
        )
    }

    @Test
    fun `쉼표로 구분되는 이름들을 가지고 자동차들을 생성한다`() {
        val racingCars = RacingCars.of("pobi,hodol", TestMovingStrategy(0))
        assertAll(
            {
                assertThat(racingCars.toList()).containsExactly(
                    RacingCar("pobi", TestMovingStrategy(0)),
                    RacingCar("hodol", TestMovingStrategy(0)),
                )
            }
        )
    }
}
