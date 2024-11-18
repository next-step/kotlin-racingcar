package race

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MoveConditionsTest {
    @Test
    fun `MoveConditions 은 갯수만큼 생성한다`() {
        assertThat(MoveConditions(2) { PositiveNumber.ONE }.size).isEqualTo(2)
    }
}
