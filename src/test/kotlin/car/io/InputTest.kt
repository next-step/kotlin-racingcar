package car.io

import car.io.Input
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test

class InputTest {
    @Test
    fun `이름을 넣어주면 컴마로 구분하여 리턴해야 한다`() {
        val input = Input(name = "오,길,환", tryCount = 3)

        val names = input.splitNameBySplitter()

        assertThat(names).containsExactly("오", "길", "환")
    }
    @Test
    fun `이름이 5글자 초과시 Exception이 나와야 한다`() {
        assertThatIllegalArgumentException().isThrownBy {
            Input(name = "오,길환인데요우,환이인데", tryCount = 3)
        }
    }
}
