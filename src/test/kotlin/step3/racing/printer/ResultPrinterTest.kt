package step3.racing.printer

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import step3.racing.car.Car
import step3.racing.rule.MockUpRule
import step3.racing.view.MockUpView
import step3.turn.Turn

internal class ResultPrinterTest {

    @Test
    fun toPrintable1() {
        val view = MockUpView()
        val rule = MockUpRule()
        assertThat(
            ResultPrinter(
                CarNamePrinter(view),
                listOf(
                    Turn(
                        cars = listOf(
                            Car("a", 3),
                            Car("bc", 4),
                            Car("aaba", 5)
                        ),
                        rule = rule
                    ),
                    Turn(
                        cars = listOf(
                            Car("a", 1),
                            Car("bc", 1),
                            Car("aaba", 1)
                        ),
                        rule = rule
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
        val rule = MockUpRule()
        ResultPrinter(
            CarNamePrinter(view),
            listOf(
                Turn(
                    cars = listOf(
                        Car("a", 3),
                        Car("bc", 4),
                        Car("aaba", 5)
                    ),
                    rule = rule
                ),
                Turn(
                    cars = listOf(
                        Car("a", 1),
                        Car("bc", 1),
                        Car("aaba", 1)
                    ),
                    rule = rule
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
