package racing.v2.fixture

import racing.v2.domain.Car
import racing.v2.domain.CarDrivingPolicy
import racing.v2.domain.CarGame
import racing.v2.domain.FixedNumberGenerator

object CarFixture {
    fun `자동차_1대_생성`(
        carName: String = "이름없음",
        alexNum: Int = 0,
    ) = Car(carName, alexNum)

    fun `자동차_3대_생성`(
        alexNum: Int,
        jasonNum: Int,
        hongNum: Int
    ) = listOf(Car("alex", alexNum), Car("jason", jasonNum), Car("hong", hongNum))

    fun 자동차게임_생성(자동차: Car, 시도횟수: Int, 숫자: Int) =
        자동차게임_생성(listOf(자동차), 시도횟수, 숫자)

    fun 자동차게임_생성(자동차_목록: List<Car>, 시도횟수: Int, 숫자: Int) =
        CarGame(자동차_목록, 시도횟수, CarDrivingPolicy(FixedNumberGenerator(숫자)))

    fun 무조건_전진하는_자동차게임_생성(자동차_목록: List<Car>, 시도횟수: Int) = 자동차게임_생성(자동차_목록, 시도횟수, 4)
}
