package racing.participant

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racing.application.ApplicationForm
import racing.application.RacingCarFactory

internal class RacingGroupTest {

    @Test
    fun `참가하는 레이서들의 레이스를 시작하면 해당 라운드의 결과가 나온다`() {
        //given
        val round = 3
        val form = ApplicationForm(listOf("cys", "qwe"))
        val group = RacingCarFactory.generate(form)

        //when
        val roundResult = group.race(round)

        //then
        assertThat(roundResult.round).isEqualTo(round)
        assertThat(roundResult.racingHistories.size).isEqualTo(2)

        //race시 움직인 거리는 랜덤이므로 검사하지 않는다.
        //해당 테스트의 목적은 라운드의 결과가 참가자의 수만큼 나오는지에 대한 단위테스트
        //실제 움직임은 RacingCar Test에서 진행
        assertThat(roundResult.racingHistories[0].name).isEqualTo("cys")
        assertThat(roundResult.racingHistories[1].name).isEqualTo("qwe")
    }
}