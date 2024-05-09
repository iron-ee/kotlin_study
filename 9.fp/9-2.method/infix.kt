package main.kotlin.fp.method

import javax.print.attribute.standard.MediaSize.Other

// downTo, step 같은 중위 호출 함수
// 변수.함수이름(argument) => 변수 함수이름 argument

fun Int.add(other: Int): Int {
    return this + other
}

infix fun Int.add2(other: Int): Int {   // 요렇게 infix 키워드를 붙여주면 됨. 그리고 infix 는 멤버함수에도 붙일 수 있음.
    return this + other
}


fun main() {
    3.add(4)

    3.add2(4)
    3 add2 4
    3 add2 4 add2 5 add2 6
}