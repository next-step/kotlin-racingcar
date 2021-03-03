package racingcar.userinterface

import racingcar.domain.Results

interface UserInterface {
    fun inputCarCount(): String
    fun inputRoundCount(): String
    fun outputResult(result: Results)
}
