package step2.module

import java.util.Queue

interface ParserModule {

    fun parse(input: String): Queue<String>
}
