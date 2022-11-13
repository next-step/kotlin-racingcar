package racing

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class NameTest {

    @ParameterizedTest
    @ValueSource(strings = ["totoro", "jisoo", "jennie"])
    fun `이름이_다섯자_이상인_경우`(name: String) {
        assertThrows<IllegalArgumentException> {
            Name.of(name)
        }
    }
}
