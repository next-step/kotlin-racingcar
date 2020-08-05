package racingcar.racing.printer

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.racing.car.Car
import racingcar.racing.result.RacingResult

internal class ResultPrinterTest {

    @Test
    fun toPrintable1() {
        assertThat(
            ResultPrinter().resultToString(
                listOf(
                    RacingResult(
                        cars = listOf(
                            Car("a", 3),
                            Car("bc", 4),
                            Car("aaba", 5)
                        )
                    ),
                    RacingResult(
                        cars = listOf(
                            Car("a", 1),
                            Car("bc", 1),
                            Car("aaba", 1)
                        )
                    )
                )
            )
        ).isEqualTo(
            "\n실행 결과\n" +
                "a : ___\n" +
                "bc : ____\n" +
                "aaba : _____\n\n" +
                "a : _\n" +
                "bc : _\n" +
                "aaba : _\n"
        )
    }

    @Test
    fun `printString() 자동차 이동거리에 따른 출력 테스트`() {
        assertThat(
            ResultPrinter().carName(Car("MOCK", distance = 0))
        ).isEqualTo("MOCK : ")

        assertThat(
            ResultPrinter().carName(Car("MOCK", distance = 3))
        ).isEqualTo("MOCK : ___")

        assertThat(
            ResultPrinter().carName(Car("MOCK", distance = 5))
        ).isEqualTo("MOCK : _____")
    }
}
