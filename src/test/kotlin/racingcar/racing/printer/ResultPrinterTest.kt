package racingcar.racing.printer

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.racing.car.Car
import racingcar.racing.result.RacingResult
import racingcar.racing.view.MockUpView

internal class ResultPrinterTest {

    @Test
    fun toPrintable1() {
        val view = MockUpView()
        assertThat(
            ResultPrinter(
                CarNamePrinter(view),
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
                ),
                view
            ).toPrintable()
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
    fun `print() 결과 출력 테스트`() {
        val view = MockUpView()
        ResultPrinter(
            CarNamePrinter(view),
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
            ),
            view
        ).print()
        assertThat(view.toString()).isEqualTo(
            "\n실행 결과\n" +
                "a : ___\n" +
                "bc : ____\n" +
                "aaba : _____\n\n" +
                "a : _\n" +
                "bc : _\n" +
                "aaba : _\n\n"
        )
    }
}
