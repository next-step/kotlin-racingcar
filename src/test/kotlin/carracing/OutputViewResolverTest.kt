package carracing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class OutputViewResolverTest {
    val outputViewResolver = OutputViewResolver()

    @Test
    fun `hyphen count should match with position`() {
        // given, when
        val viewResult = outputViewResolver.makeCarPositionsView(listOf(1, 2, 5))
        // then
        assertThat(
            viewResult.equals(
                """
            -
            --
            -----
        """,
            ),
        )
    }
}
