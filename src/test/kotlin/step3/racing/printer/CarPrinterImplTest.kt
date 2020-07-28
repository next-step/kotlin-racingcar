package step3.racing.printer

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import step3.racing.car.CarImpl
import step3.racing.view.MockUpView

class CarPrinterImplTest {
    @Test
    fun `printString() 자동차 이동거리에 따른 출력 테스트`() {
        assertThat(
            CarPrinterImpl(MockUpView())
                .printString(CarImpl("MOCK").apply { distance = 0 })
        ).isEqualTo("MOCK : ")

        assertThat(
            CarPrinterImpl(MockUpView())
                .printString(CarImpl("MOCK").apply { distance = 3 })
        ).isEqualTo("MOCK : ___")

        assertThat(
            CarPrinterImpl(MockUpView())
                .printString(CarImpl("MOCK").apply { distance = 5 })
        ).isEqualTo("MOCK : _____")
    }

    @Test
    fun `print() 결과 값이 출력되는지 테스트`() {
        val mockUpView = MockUpView()
        CarPrinterImpl(mockUpView)
            .print(CarImpl("MOCK").apply { distance = 3 })
        assertThat(mockUpView.toString()).isEqualTo("MOCK : ___\n")
    }
}
