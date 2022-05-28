package _3_racing_car

import _3_racing_car.domain.Name
import _3_racing_car.domain.power.Power
import _3_racing_car.domain.power.RandomPower
import _3_racing_car.domain.racer.Car
import _3_racing_car.domain.racer.Racer
import _3_racing_car.service.Racing
import _3_racing_car.service.dto.RacingInputDto
import _3_racing_car.ui.Game
import _3_racing_car.ui.InputView

fun main() {
    val input = InputView()
    val gameInput = input.read()

    val racingInput: Map<Racer, Power> = gameInput.gamers.associate { Car(Name(it)) to RandomPower(0, 9) }
    val racing = Racing(RacingInputDto(racingInput))

    val game = Game()
    val result = game.play(racing, gameInput.times)

    result.print()
}
