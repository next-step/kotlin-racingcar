package onestep.racingcar.model

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class RacingTest {

    @Test
    fun `Should be EqualTo, CarCount And racing's Result Size`() {
        val racing = Racing(3, 3)
        Assertions.assertThat(racing.race { }.size).isEqualTo(3)
    }

    @Test
    fun `Should not be Empty, When CarCount's Input Greater than 0`() {
        val racing = Racing(3, 3)
        Assertions.assertThat(racing.race { }).isNotEmpty
    }

    @Test
    fun `Should be Empty, When CarCount's Input is 0`() {
        val racing = Racing(0, 3)
        Assertions.assertThat(racing.race { }).isEmpty()
    }
}
