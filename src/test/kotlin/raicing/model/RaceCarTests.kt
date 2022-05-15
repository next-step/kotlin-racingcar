package raicing.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import raicing.strategy.CarMovingStrategy

class RaceCarTests {
    @Nested
    @DisplayName("RaceCar의 of()를 이용하여 RaceCar를 생성")
    inner class RaceCarOfTests {
        @ParameterizedTest(name = "자동차 대수가 `{0}` 이면, getCars()의 size도 `{0}` 이다.")
        @ValueSource(ints = [1, 3, 10])
        fun `입력받은 자동차의 대수만큼 자동차 리스트의 길이가 만들어져야 한다`(carCount: Int) {
            val raceCar = RaceCar.of(NaturalNumber(carCount.toString()))
            assertThat(raceCar.getCars().size).isEqualTo(carCount)
        }
    }

    @Nested
    @DisplayName("경주 1회 테스트")
    inner class RaceOnceTests {
        @Test
        fun `raceOnce()를 실행하면 자동차의 position이 그대로이거나 1 증가한다`() {
            val raceCar = RaceCar.of(NaturalNumber("5"))

            val afterRaceCar = raceCar.raceOnce(CarMovingStrategy)
            assertAll(
                {
                    raceCar.getCars().zip(afterRaceCar.getCars()) { car, afterCar ->
                        assertThat(afterCar.name).isEqualTo(afterCar.name)
                        assertThat(afterCar.position).isIn(car.position, car.position + 1)
                    }
                }
            )
        }
    }
}
