package racingcar.racing.printer

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.racing.car.Car
import racingcar.racing.view.MockUpView

class CarNamePrinterTest {
    @Test
    fun `printString() 자동차 이동거리에 따른 출력 테스트`() {
        assertThat(
            CarNamePrinter(MockUpView())
                .printString(Car("MOCK", distance = 0))
        ).isEqualTo("MOCK : ")

        assertThat(
            CarNamePrinter(MockUpView())
                .printString(Car("MOCK", distance = 3))
        ).isEqualTo("MOCK : ___")

        assertThat(
            CarNamePrinter(MockUpView())
                .printString(Car("MOCK", distance = 5))
        ).isEqualTo("MOCK : _____")
    }

    @Test
    fun `print() 결과 값이 출력되는지 테스트`() {
        val mockUpView = MockUpView()
        CarNamePrinter(mockUpView)
            .print(Car("MOCK", distance = 3))
        assertThat(mockUpView.toString()).isEqualTo("MOCK : ___\n")
    }
}
