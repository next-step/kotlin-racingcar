package raicing.model

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import raicing.Const
import raicing.strategy.CarMovingStrategy

class RaceCarTests {
    @Nested
    @DisplayName("RaceCar의 of()를 이용하여 RaceCar를 생성")
    inner class RaceCarOfTests {
        @Test
        fun `입력받은 자동차의 이름 수만큼 경주할 자동차 리스트의 길이가 만들어져야 한다`() {
            val carNames = listOf("a", "b", "c", "d", "e")
            val raceCar = RaceCar.of(carNames)

            assertAll(
                {
                    raceCar.getCars().zip(carNames) { car, carName ->
                        assertThat(car.name).isEqualTo(carName)
                    }
                }
            )

            assertThat(raceCar.getCars().size).isEqualTo(carNames.size)
        }
    }

    @Nested
    @DisplayName("입력받은 문자열을 자동차 이름 리스트로 변환 테스트")
    inner class SplitCarNamesTests {
        @ParameterizedTest(name = "입력값이 `{0}` 이면 IllegalArgumentException 발생")
        @ValueSource(strings = [",b", " ,", "a,", "abcdefgh, abc"])
        fun `입력값에 비어있는 값이 있거나, 5자를 초과하면 실패 - IllegalArgumentException 발생`(carNameStr: String) {
            Assertions.assertThatIllegalArgumentException()
                .isThrownBy { RaceCar.splitCarNames(carNameStr) }
                .withMessage(Const.ErrorMsg.CAR_NAME_IS_TOO_LONG)
        }

        @ParameterizedTest(name = "입력값이 `{0}` 이면 성공 - 경주할 자동차 이름의 개수는 `{1}`개")
        @CsvSource(
            value = [
                "abc, bde / 2",
                "a, b, c, d, e / 5",
                "한글,테,스트 / 3"
            ],
            delimiter = '/'
        )
        fun `입력값에 5자 이하인 이름만 있으면 성공`(carNameStr: String, carCount: Int) {
            val result = RaceCar.splitCarNames(carNameStr)
            assertThat(result.size).isEqualTo(carCount)
        }
    }

    @Nested
    @DisplayName("경주 1회 테스트")
    inner class RaceOnceTests {
        @Test
        fun `raceOnce()를 실행하면 자동차의 position이 그대로이거나 1 증가한다`() {
            val raceCar = RaceCar.of(listOf("a", "b", "c", "d", "e"))

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
