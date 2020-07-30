import Racing.Start
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class RacingTest {
    @Test
    @DisplayName("check Racing.Start")
    fun starttest() {
        assertThat(Start().cars(3)).isEqualTo(mapOf("car0" to 1, "car1" to 1, "car2" to 1))
    }
/*  프린트 테스트 방법은 습득을 못했습니다.
    @Test
    @DisplayName("check print")
    fun `check print`(){
        val sample = mutableMapOf("car1" to 2)
        assertThat(Racing.Printcircuit().circuitprint(sample)).isEqualTo("__")
    } */
    /*      랜덤을 테스트 하는 방법도 실행을 못했습니다.
    @Test
    @DisplayName("final check")
    fun `final check`(){
        val sample = mutableMapOf("car0" to 1, "car1" to 1, "car2" to 1)
        assertThat(Racing.Circuit().)
    }
    */
}
