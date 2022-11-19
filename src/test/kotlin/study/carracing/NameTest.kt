package study.carracing

import carracing.domain.Car
import carracing.domain.Name
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class NameTest {

    @Test
    fun getCarName() {
        Assertions.assertThat(Name("lee").name).isEqualTo("lee")
    }

    @Test
    fun `다섯글자 이상의 이름 입력 시 오류 발생`() {
        assertThrows<IllegalArgumentException> {
            Car(Name("risandra"))
        }
    }
}
