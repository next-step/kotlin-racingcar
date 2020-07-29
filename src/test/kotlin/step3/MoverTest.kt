package step3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import step3.domain.Mover

internal class MoverTest {

    @ValueSource(booleans = [true, false])
    @ParameterizedTest
    fun `원하는 Boolean값이 나오는지 확인`(expectedBoolean: Boolean) {
        // given
        val carMover = object : Mover {
            override fun canMove(): Boolean {
                return expectedBoolean
            }
        }

        // then
        assertThat(carMover.canMove()).isEqualTo(expectedBoolean)
    }
}
