package study

import fixture.CarFixture.KIM_NAME
import fixture.CarFixture.PACK_NAME
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StringTest {

    @Test
    fun joinTo() {
        val names = listOf(KIM_NAME, PACK_NAME)

        val joinedNames = names.joinToString(", ")

        assertThat(joinedNames).isEqualTo("kim, pack")
    }
}
