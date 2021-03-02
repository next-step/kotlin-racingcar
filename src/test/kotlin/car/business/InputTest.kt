package car.business

import car.io.Input
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class InputTest {
    @Test
    fun `이름을 넣어주면 컴마로 구분하여 리턴해야 한다`() {
        val input = Input(name = "오,길,환", tryCount = 3)

        val names = input.splitNameBySplitter()

        assertThat(names).containsExactly("오", "길", "환")
    }
}
