package domain.step4.domain.racingcar

import global.strategy.split.SplitStrategy

class Names private constructor(private val _names: List<Name>) {

    fun size(): Int = _names.size

    companion object {
        fun ofList(names: List<Name>): Names = Names(names.toList())
        fun ofStringWithSplitStrategy(target: String, splitStrategy: SplitStrategy): Names =
            ofList(splitStrategy.split(target)
                .map { name -> Name(name) }
                .toList())
    }

}