package step3.racingcar.service

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import step3.racingcar.domain.Car
import step3.racingcar.domain.Cars
import step3.racingcar.domain.PlayInfo
import step3.racingcar.fixture.TestRandomNumberGenerator

internal class RacingCarServiceTest : BehaviorSpec({
    lateinit var racingCarService: RacingCarService

    given("단일 라운드를 진행할 참가 차량 한대가 주어지고") {
        val 참가_차량 = Car("참가 차량")
        val given = Cars.of(listOf(참가_차량))
        val playInfo = PlayInfo(given, 1)

        `when`("4이상의 난수가 발생하면") {
            racingCarService = of(4)
            racingCarService.play(playInfo)
            then("차량의 주행거리는 1 누적된다.") {
                참가_차량.distance shouldBe 1
            }
        }
    }

    given("두 라운드를 진행할 참가 차량 한대가 주어지고") {
        val 참가_차량 = Car("참가 차량")
        val given = Cars.of(listOf(참가_차량))

        `when`("첫번째 라운드에 4이상의 난수가 발생하면") {
            racingCarService = of(4)
            racingCarService.playEachRound(0, given)
            then("차량의 주행거리는 1 누적된다.") {
                참가_차량.distance shouldBe 1
            }
        }
        `when`("두번째 라운드에 3이하의 난수가 발생하면") {
            racingCarService = of(3)
            racingCarService.playEachRound(1, given)
            then("차량의 주행거리는 누적되지 않는다.") {
                참가_차량.distance shouldBe 1
            }
        }
    }

    given("단일 라운드를 진행할 참가 차량 두대가 주어지고") {
        val 첫번째_참가_차량 = Car("첫번째_참가_차량")
        val 두번째_참가_차량 = Car("두번째_참가_차량")
        val given = Cars.of(listOf(첫번째_참가_차량, 두번째_참가_차량))

        `when`("첫번째 차량에는 4의 난수가, 두번째 차량에는 3의 난수가 발생하면") {
            racingCarService = of(4).also {
                it.playEachRoundByCar(첫번째_참가_차량)
            }
            racingCarService = of(3).also {
                it.playEachRoundByCar(두번째_참가_차량)
            }
            then("첫번째 차량이 누적거리 1로 우승한다.") {
                첫번째_참가_차량.distance shouldBe 1
                given.winnerNames() shouldBe "첫번째_참가_차량"
            }
        }
    }

    given("두 라운드를 진행할 참가 차량 두대가 주어지고") {
        val 첫번째_참가_차량 = Car("첫번째_참가_차량")
        val 두번째_참가_차량 = Car("두번째_참가_차량")
        val given = Cars.of(listOf(첫번째_참가_차량, 두번째_참가_차량))

        `when`("첫번째 라운드에는 첫번째 차량에는 4의 난수가, 두번째 차량에는 3의 난수가 발생하고") {
            racingCarService = of(4).also {
                it.playEachRoundByCar(첫번째_참가_차량)
            }
            racingCarService = of(3).also {
                it.playEachRoundByCar(두번째_참가_차량)
            }
            then("첫번째 차량을 우승 차량으로 반환한다.") {
                given.winnerNames() shouldBe "첫번째_참가_차량"
            }
        }

        `when`("두번째 라운드에는 두 차량 모두 4의 난수가 발생하면") {
            racingCarService = of(4).also {
                it.playEachRoundByCar(첫번째_참가_차량)
            }
            racingCarService = of(4).also {
                it.playEachRoundByCar(두번째_참가_차량)
            }
            then("첫번째 차량이 누적거리 2로 우승한다.") {
                첫번째_참가_차량.distance shouldBe 2
                given.winnerNames() shouldBe "첫번째_참가_차량"
            }
        }
    }
})

fun of(randomNumber: Int): RacingCarService = RacingCarService(TestRandomNumberGenerator(randomNumber))
