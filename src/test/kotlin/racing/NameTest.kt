package racing

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racing.domain.Name

class NameTest {

    @ParameterizedTest
    @ValueSource(strings = ["totoro", "jinsoo", "jennie"])
    fun `이름이_다섯자_초과인_경우`(name: String) {
        assertThrows<IllegalArgumentException> {
            Name.of(name)
        }
    }
}
