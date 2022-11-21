package racingcar.view.store

import racingcar.domain.Round

object RoundStore : Store<List<Round>>(initialState = listOf())
