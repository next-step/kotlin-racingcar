package step3.racingcar.service

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import step3.racingcar.domain.Cars
import step3.racingcar.domain.PlayInfo
import step3.racingcar.fixture.CarFixtureGenerator.Companion.난수를_가지는_차량_생성

internal class RacingCarServiceTest : BehaviorSpec({
    val racingCarService = RacingCarService()

    given("참가 차량 한대에 숫자 4가 주어지고") {
        val 참가_차량 = 난수를_가지는_차량_생성(4)
        val given = Cars.of(listOf(참가_차량))
        val playInfo = PlayInfo(given, 1)

        `when`("해당 라운드를 진행하면") {
            racingCarService.play(playInfo)
            then("차량은 한칸 전진한다.") {
                참가_차량.distance shouldBe 1
            }
        }
    }

    given("참가 차량 한대에 숫자 4와 3이 주어지고") {
        val 참가_차량 = 난수를_가지는_차량_생성(4, 3)
        val given = Cars.of(listOf(참가_차량))
        val playInfo = PlayInfo(given, 2)

        `when`("각 라운드를 진행하면") {
            racingCarService.play(playInfo)
            then("차량은 한칸 전진한다.") {
                참가_차량.distance shouldBe 1
            }
        }
    }

    given("두 차량에 각각 4와 3이 주어지고") {
        val 첫번째_참가_차량 = 난수를_가지는_차량_생성(4)
        val 두번째_참가_차량 = 난수를_가지는_차량_생성(3)
        val given = Cars.of(listOf(첫번째_참가_차량, 두번째_참가_차량))
        val playInfo = PlayInfo(given, 1)

        `when`("해당 라운드를 진행하면") {
            racingCarService.play(playInfo)
            then("각 차량의 진행 거리를 확인할 수 있다.") {
                첫번째_참가_차량.distance shouldBe 1
                두번째_참가_차량.distance shouldBe 0
            }
        }
    }

    given("여러 차량에 숫자를 주입하고") {
        val 첫번째_참가_차량 = 난수를_가지는_차량_생성(4, 5)
        val 두번째_참가_차량 = 난수를_가지는_차량_생성(3, 5)
        val given = Cars.of(listOf(첫번째_참가_차량, 두번째_참가_차량))
        val playInfo = PlayInfo(given, 2)

        `when`("각 라운드를 진행하면") {
            racingCarService.play(playInfo)
            then("각 차량의 진행 거리를 확인할 수 있다.") {
                첫번째_참가_차량.distance shouldBe 2
                두번째_참가_차량.distance shouldBe 1
            }
        }
    }
})
