package racingcar

import org.assertj.core.api.AssertionsForClassTypes
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream

class ApplicationKtTest {
    @Test
    fun `입력값이 숫자가 아닌 경우 예외처리 테스트`() {
        val inputString = "5\nt" // 입력 값을 줄바꿈으로 구분
        val inputStream = ByteArrayInputStream(inputString.toByteArray())
        System.setIn(inputStream)

        AssertionsForClassTypes.assertThatThrownBy { main() }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `입력값이 1보다 작은 경우 예외 처리 테스트`() {
        val inputString = "0\nt" // 입력 값을 줄바꿈으로 구분
        val inputStream = ByteArrayInputStream(inputString.toByteArray())
        System.setIn(inputStream)

        AssertionsForClassTypes.assertThatThrownBy { main() }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

}
