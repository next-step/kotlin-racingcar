package step3.car.printer

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import step3.car.CarImpl
import java.io.ByteArrayOutputStream
import java.io.PrintStream

/**
 * 프린트 할 문자열을 단위테스트로 테스트하고
 * 콘솔에 출력하는 기능의 경우는 시스템의 출력을 명시적으로 바이트스트림으로 잠시 바꾼 뒤
 * 해당 스트림으로 출력이 되는지 확인한다.
 * 소스 출처 : https://stackoverflow.com/questions/1119385/junit-test-for-system-out-println
 */
class CarPrinterImplTest {
    private val outContent = ByteArrayOutputStream()
    private val originalOut = System.out

    @BeforeEach
    fun setUpStreams() {
        System.setOut(PrintStream(outContent))
    }

    @AfterEach
    fun restoreStreams() {
        System.setOut(originalOut)
    }

    @Test
    fun `printString() 자동차 이동거리에 따른 출력 테스트`() {
        assertThat(
            CarPrinterImpl()
                .printString(CarImpl().apply { distance = 0 })
        ).isEqualTo("")

        assertThat(
            CarPrinterImpl()
                .printString(CarImpl().apply { distance = 3 })
        ).isEqualTo("___")

        assertThat(
            CarPrinterImpl()
                .printString(CarImpl().apply { distance = 5 })
        ).isEqualTo("_____")
    }

    @Test
    fun `print() 결과 값이 콘솔에 출력되는지 테스트`() {
        CarPrinterImpl()
            .print(CarImpl().apply { distance = 3 })
        assertThat(outContent.toString()).isEqualTo("___\n")
    }
}
