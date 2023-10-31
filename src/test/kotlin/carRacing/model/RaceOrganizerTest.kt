package carRacing.model

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class RaceOrganizerTest : BehaviorSpec({
    Given("stevy 라는 이름의 차량을 포함한 4대의 차량이 생성 되었다.") {
        val carList = listOf<Car>(Car(0, "stevy"), Car(0, "jisu"), Car(0, "tomi"), Car(0, "kuku"))
        val raceOrganizer = RaceOrganizer(carList)
        When("경기 규칙은 stevy 만 앞으로 갈 수 있고 5번의 경기를 한다.") {
            raceOrganizer.startRace(5) {
                it.getCarName() == "stevy"
            }
            Then("5라운드 때 stevy 차량의 위치는 5여야 한다") {
                raceOrganizer.getRaceResult()
                    .first { it.round == 5 }.CarStatus.first { it.name === "stevy" }.curPosition shouldBe 5
            }
        }
    }
})
