package domain.step4.domain.racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Test

class NamesTest {

    @Test
    fun `1개 이상의 값을 가진 콜렉션이 입력되면 생성 가능하다`() {
        val names = Names(listOf(Name("test")))

        assertAll(
            { assertThat(names).isNotNull },
            { assertThat(names).isExactlyInstanceOf(Names::class.java) }
        )
    }

}