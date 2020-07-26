package onestep.racingcar.model

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class RacingTest {

    @Test
    fun `Happy Case`() {
        Racing(3, 3).run {
            ready()
            race {
                Assertions.assertThat(it).isNotEmpty
            }
        }
    }

    @Test
    fun `Should Exception(Before Race, Need Ready) When don't Execute ready()`() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            Racing(3, 3).run {
                race {
                    Assertions.assertThat(it).isNotEmpty
                }
            }
        }
    }
}
