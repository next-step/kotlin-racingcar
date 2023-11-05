package racing.v2.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe

class `CarGame_StartRound_테스트` : BehaviorSpec({

    Given("alex 자동차가 경주 게임을 진행할 때") {
        When("4 이상의 숫자가 나올 경우") {
            listOf(4, 5, 6, 7, 8, 9).forEach {
                val (alex_자동차, 자동차게임) = 알렉스_단독_자동차게임_생성(it)

                Then("alex 자동차의 위치는 1 증가한다.") {
                    자동차게임.startRound()
                    alex_자동차.position shouldBe 1
                }
            }
        }

        When("3 이하의 숫자가 나올 경우") {
            listOf(0, 1, 2, 3).forEach {
                val (alex_자동차, 자동차게임) = 알렉스_단독_자동차게임_생성(it)

                Then("alex 자동차의 위치는 초기 값 그대로 0이다.") {
                    자동차게임.startRound()
                    alex_자동차.position shouldBe 0
                }
            }
        }
    }
})

private fun `알렉스_단독_자동차게임_생성`(number: Int): Pair<Car, CarGame> {
    val alex_자동차 = Car("alex")
    val `자동차_목록` = listOf(alex_자동차)
    val `시도_횟수` = 1
    val `자동차게임` = CarGame(`자동차_목록`, `시도_횟수`, FakeCarGameRandomGenerator(number))
    return Pair(alex_자동차, 자동차게임)
}

class `CarGame_findWinners_테스트` : BehaviorSpec({
    Given("alex, jason, hong 이름을 가진 각각의 자동차가 경주 게임이 끝났을 때") {

        When("자동차 위치가 제일 높은 사람이 1명일 때") {
            val 우승자 = 게임_생성_후_우승자_조회(3, 2, 1)

            Then("1명의 우승자가 포함된 자동차 목록이 반환된다.") {
                우승자 shouldHaveSize 1
                우승자[0].name shouldBe "alex"
            }
        }

        When("자동차 위치가 제일 높은 사람이 2명일 때") {
            val 우승자 = 게임_생성_후_우승자_조회(3, 3, 1)

            Then("2명의 우승자가 포함된 자동차 목록이 반환된다.") {
                우승자 shouldHaveSize 2
                우승자[0].name shouldBe "alex"
                우승자[1].name shouldBe "jason"
            }
        }

        When("자동차 위치가 제일 높은 사람이 3명일 때") {
            val 우승자 = 게임_생성_후_우승자_조회(3, 3, 3)

            Then("3명의 우승자가 포함된 자동차 목록이 반환된다.") {
                우승자 shouldHaveSize 3
                우승자[0].name shouldBe "alex"
                우승자[1].name shouldBe "jason"
                우승자[2].name shouldBe "hong"
            }
        }
    }
})

private fun `게임_생성_후_우승자_조회`(alexNum: Int, jasonNum: Int, hongNum: Int): List<Car> {
    val `자동차_목록` = listOf(Car("alex", alexNum), Car("jason", jasonNum), Car("hong", hongNum))
    val `자동차게임` = CarGame(`자동차_목록`, 0, FakeCarGameRandomGenerator(4))
    return 자동차게임.findWinners()
}

class `CarGame_시도횟수_테스트` : BehaviorSpec({
    Given("자동차 게임에서 시도횟수가 1일 때") {
        val 시도횟수 = 1
        val 자동차게임 = CarGame(listOf(Car("alex")), 시도횟수, FakeCarGameRandomGenerator(4))

        When("게임 라운드를 1회 진행한 경우") {
            자동차게임.startRound()

            Then("남은 라운드는 없다.") {
                자동차게임.hasMoreRounds() shouldBe false
            }
        }
    }
})
