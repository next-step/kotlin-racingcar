package study

import domain.Race

class CarRaceTest {

    private lateinit var carRace: Race

    // @BeforeEach
    // fun `CarRace 초기 설정`() {
    //     carRace = Race()
    //     carRace.initCarMovementCountList(1)
    // }
    //
    // @Test
    // fun `carCount 에 해당하는 count 확인`() {
    //     assertThat(carRace.moveCar(0)).isEqualTo(carRace.getCarMovementCountList(0).count)
    // }
    //
    // @Test
    // fun `경주 자동차가 없는 경우`() {
    //     assertThatThrownBy {
    //         Race().moveCar(0)
    //     }.isInstanceOf(IndexOutOfBoundsException::class.java).hasMessage("The car does not exist.")
    // }
}
