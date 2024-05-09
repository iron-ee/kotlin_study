package main.kotlin.exception

import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.nio.file.Path

fun exception() {

}

fun parseIntOrThrowV2(str: String): Int? {
    return try {
        str.toInt()
    } catch (e: NumberFormatException) {
        null
    }
}

fun readFile() {    // kotlin 에서는 java 와 달리 checked exception 과 unchecked exception 을 구분하지 않는다. 모두 unchecked exception 이다.
    val currentFile = File(".")
    val file = File(currentFile.absolutePath + "/a.txt")
    val reader = BufferedReader(FileReader(file))
    println(reader.readLine())
    reader.close()
}


class FilePrinter {

    fun readFile(path: String) {    // kotlin 에서는 try with resources 구문이 없음. 대신 use 라는 inline 확장함수를 사용함.
        BufferedReader(FileReader(path)).use { reader ->
            println(reader.readLine())
        }
    }
}


/*
try catch finally 구문은 문법적으로 java 와 완전 동일하다.
kotlin 에서는 try catch 가 expression 이다.
kotlin 에서 모든 예외는 unchecked exception 이다.
kotlin 에서는 try with resources 구문이 없다. 대신 kotlin 의 언어적 특징을 활용해 close 를 호출 해준다.
* */
