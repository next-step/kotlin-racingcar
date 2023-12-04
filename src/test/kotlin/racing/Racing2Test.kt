package racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import kotlin.random.Random

class Racing2Test {

    @Test
    fun `항상 전진하는 레이싱 규칙을 주입받고, 5번 플레이 했을 때, 모든 자동차의 위치는 +5가 된다`() {
        // given : 항상 전진하는 규칙의 레이싱을 생성한다.
        val cars2 = Cars2(listOf(Car2("aa"), Car2("bb"), Car2("cc"), Car2("dd")))
        val racing2 = Racing2(cars2, FakeCarMoveLogic())

        // when : 5번의 이동을 입력 받는다.
        racing2.play(5)

        // then : 모든 자동차의 위치는 초기 값 +5가 된다.(Default = 0)
        val expect = Cars2(listOf(Car2("aa", 5), Car2("bb", 5), Car2("cc", 5), Car2("dd", 5)))
        assertThat(racing2.cars).isEqualTo(expect)
    }
}
