package racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racing.domain.FakeCarMoveLogic
import racing.domain.Racing

class RacingTest {

    @Test
    fun `항상 전진하는 레이싱 규칙을 주입받고, 5번 플레이 했을 때, 모든 자동차의 위치는 +5가 된다`() {
        // given : 항상 전진하는 규칙의 레이싱을 생성한다.
        val playCarList2 = PlayCarList(listOf(Car("aa"), Car("bb"), Car("cc"), Car("dd")))
        val racing = Racing(playCarList2, FakeCarMoveLogic())

        // when : 5번의 이동을 입력 받는다.
        racing.play(5)

        // then : 모든 자동차의 위치는 초기 값 +5가 된다.(Default = 0)
        val expect = PlayCarList(listOf(Car("aa", 5), Car("bb", 5), Car("cc", 5), Car("dd", 5)))
        assertThat(racing.playCarList).isEqualTo(expect)
    }
}
