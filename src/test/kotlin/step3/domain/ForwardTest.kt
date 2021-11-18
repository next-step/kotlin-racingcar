package step3.domain

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

/**
 *
 * @author Leo
 */
class ForwardTest {

    @Test
    fun `100퍼센트 확률일시 전진 되는지 검증`() {
        // given
        var forward: Forward

        // when
        forward = FakeForwardImpl()

        // then
        assertTrue(forward.moved())
    }

}
