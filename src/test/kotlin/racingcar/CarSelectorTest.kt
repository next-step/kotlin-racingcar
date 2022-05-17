package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

internal class CarSelectorTest {

    @Test
    fun `쉼표 기준 이름 자르기`() {
        val carSelector = CarSelector("a,b,c")

        assertAll("이름 확인", {
            assertThat(carSelector.names.contains("a"))
            assertThat(carSelector.names.contains("b"))
            assertThat(carSelector.names.contains("c"))
        })
    }
}
