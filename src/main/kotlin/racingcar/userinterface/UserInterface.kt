package racingcar.userinterface

import racingcar.domain.Results

interface UserInterface {
    fun inputCarNames(): List<String>
    fun inputRoundCount(): String
    fun outputResult(results: Results)
}
