package racing.domain

import racing.controller.GameUserInputInterface
import racing.controller.MakeEntryCars
import racing.controller.RandomNumberInput
import racing.view.GameInfo
import racing.view.PrintRaceDisplay
import racing.view.RaceDisplayInterface

/*
car list 를 멤버로 가지며
이동 로직(랜덤 숫자로 이동) 에 대한 처리를 함
 */
class RacingGame(
    private val gameInfo: GameInfo,
    controller: GameUserInputInterface = RandomNumberInput(),
    private val displayInterface: RaceDisplayInterface = PrintRaceDisplay(),
) {
    private val cars = MakeEntryCars(gameInfo.carNames, controller).makeEntry()
    private var currentRound: Int = 0
    private val winners: RaceResult by lazy {
        RaceResult(cars)
    }

    fun getCarCount(): Int {
        return cars.size
    }

    fun getCar(index: Int): CarModel? {
        return cars.getOrNull(index)
    }

    fun hasNextRound(): Boolean {
        return (currentRound < gameInfo.rounds)
    }

    fun nextRound() {
        check(hasNextRound())
        currentRound++
        for (car in cars) {
            car.nextState()
        }

        if (hasNextRound().not()) {
        }
    }

    fun getWinners(): List<CarModel> {
        check(hasNextRound().not()) { "아직 게임 중이에요." }
        return winners.getWinners()
    }

    fun getWinnerNames(): String {
        check(hasNextRound().not()) { "아직 게임 중이에요." }
        return winners.getCarNames()
    }

    fun startGame() {
        repeat(gameInfo.rounds) {
            nextRound()
            displayInterface.displayRacing(cars)
        }
        displayInterface.displayWinners(winners)
    }
}
