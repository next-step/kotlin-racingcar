package raicing.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class RaceCarTests {
    @Nested
    @DisplayName("RaceCar의 of()를 이용하여 RaceCar를 생성")
    inner class RaceCarOfTests {
        @Test
        fun `입력받은 자동차의 이름 수만큼 경주할 자동차 리스트의 길이가 만들어져야 한다`() {
            val carNames = listOf(
                CarInfo("a"),
                CarInfo("b"),
                CarInfo("c"),
                CarInfo("d"),
                CarInfo("e")
            )
            val raceCar = RaceCar.of(carNames)

            assertAll(
                {
                    raceCar.getCars().zip(carNames) { car, carName ->
                        assertThat(car.carInfo).isEqualTo(carName)
                    }
                }
            )

            assertThat(raceCar.getCars().size).isEqualTo(carNames.size)
        }
    }
}
