package step3.racingcar.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

internal class CarsTest : BehaviorSpec({
    given("경주를 완료한 자동차 객체 목록이 주어지고") {
        val 첫_번째_차량 = 경주를_완료한_차량_생성("첫 번째 차량", 1, 1, 1, 4, 4)
        val 두_번째_차량 = 경주를_완료한_차량_생성("두 번째 차량", 1, 1, 4, 4, 4)
        val 세_번째_차량 = 경주를_완료한_차량_생성("세 번째 차량", 4, 4, 4, 1, 1)

        `when`("우승자 객체를 생성하면") {
            val 참가_차량_목록 = listOf(첫_번째_차량, 두_번째_차량, 세_번째_차량)
            val given = Cars.of(참가_차량_목록)
            then("우승한 차량들의 이름을 반환한다.") {
                given.winnerNames() shouldBe "${두_번째_차량.name}, ${세_번째_차량.name}"
            }
        }
    }
})
private fun 경주를_완료한_차량_생성(carName: String, vararg randomNumbers: Int): Car {
    val car = Car(carName)
    randomNumbers.forEach {
        car.race(it)
    }
    return car
}
