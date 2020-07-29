package step3.racing.printer

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import step3.racing.car.CarImpl
import step3.racing.mock.MockUpView

class CarPrinterImplTest {
    @Test
    fun `printString() 자동차 이동거리에 따른 출력 테스트`() {
        assertThat(
            CarPrinterImpl(MockUpView())
                .printString(CarImpl().apply { distance = 0 })
        ).isEqualTo("")

        assertThat(
            CarPrinterImpl(MockUpView())
                .printString(CarImpl().apply { distance = 3 })
        ).isEqualTo("___")

        assertThat(
            CarPrinterImpl(MockUpView())
                .printString(CarImpl().apply { distance = 5 })
        ).isEqualTo("_____")
    }

    @Test
    fun `print() 결과 값이 출력되는지 테스트`() {
        val mockUpView = MockUpView()
        CarPrinterImpl(mockUpView)
            .print(CarImpl().apply { distance = 3 })
        assertThat(mockUpView.toString()).isEqualTo("___\n")
    }
}
