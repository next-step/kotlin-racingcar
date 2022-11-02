import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `해인테스트`() {
        val person = main()
        assertThat(person.main()).hasSize(3)
    }


}