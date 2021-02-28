package racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racing.application.ApplicationForm
import racing.application.RacingCarFactory

internal class RacingGameTest {

    @Test
    fun `라운드 수를 0으로 입력하면 전체 결과는 0이다`() {
        //given
        val participantCount = 2
        val form = ApplicationForm(participantCount)
        val group = RacingCarFactory.generate(form)

        //when
        val result = RacingGame(group).start(0)

        //then
        assertThat(result.roundResults.size).isEqualTo(0)
    }

    @Test
    fun `총 라운드 횟수만큼 결과가 생성된다`() {
        //given
        val participantCount = 2
        val form = ApplicationForm(participantCount)
        val group = RacingCarFactory.generate(form)

        //when
        val result = RacingGame(group).start(3)

        //then
        assertThat(result.roundResults.size).isEqualTo(3)
        assertThat(result.roundResults[0].round).isEqualTo(1)
        assertThat(result.roundResults[1].round).isEqualTo(2)
        assertThat(result.roundResults[2].round).isEqualTo(3)
    }
}