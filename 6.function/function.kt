package main.kotlin.function

import java.util.Random
import java.util.Scanner
import java.util.Timer
import kotlin.concurrent.timerTask


fun function() {
    // 함수
    // 함수 선언 방법
    // fun 함수명(변수명1: 변수타입, 변수명2: 변수타입, ...): 반환되는 함수타입 {}
    // 또한 kotlin 에서 쓸 수 있는 특성들도 있다. -> 많은 것을 생략할 수도 있다.
    fun cal1(a: Int, b: Int): Int {
        if (a > b) {
            return a
        } else {
            return b
        }
    }

    fun cal2(a: Int, b: Int): Int {
        return if (a > b) {     // if else 구문은 expression 이라서 바로 return 뒤에 놔줄 수 있다.
            a
        } else {
            b
        }
    }

    fun cal3(a: Int, b: Int): Int = if (a > b) {        // 리턴이 바로 본문 이라면 {} block 대신 = 으로 사용 가능
        a
    } else {
        b
    }

    // = 으로 함수를 사용하는 경우 반환 타입도 생략 가능 -> cal1 에서 cal4 코드로 완전히 간결해졌음.
    fun cal4(a: Int, b: Int) = if (a > b) a else b


//    val result1: Int = sum(3,5)
//    println("result1 : $result1")

//    printLoop()
//    calculator()
//    gameMain()

    // 매개변수 이름을 통해 직접 지정해 줄 수도 있다 (named argument), 지정되지 않은 매개변수는 기본값 사용
    // builder 를 직접 만들지 않고 builder 의 장점을 가지게 된다.
    // 그치만 kotlin 에서 java 함수를 가져다 사용할 때는 named argument 를 사용할 수 없다.
    repeat(str = "", useNewLine = false)


    // 같은 타입의 파라미터를 여러개 받기 (가변인자)
    // 배열을 직접 넣거나, comma 를 이용해 여러 파라미터를 넣거나
    printAll("a", "b", "c")
    val array = arrayOf("a", "b", "c")
    printAll(*array)    // 배열을 바로 넣어줄 수도 있는데, 바로 넣는 대신 스프레드 연산자(*) 를 붙여줘야 함.
}

fun sum(a: Int, b: Int): Int {
    return a + b
}

fun printLoop() {
    for (index: Int in 0..10) {
        if (index == 5) {
            return
        }
        println("index = ${index}")
    }
    println("End printLoop()")
}

fun minus(a: Int, b: Int): Int {
    return a - b
}

fun multiply(a: Int, b: Int): Int {
    return a * b
}

fun divide(a: Double, b: Int): Double {
    return a / b
}

fun calculator() {
    val sc = Scanner(System.`in`)
    print("첫 번째 숫자를 입력해주세요 : ")
    val first = sc.nextInt()
    print("두 번째 숫자를 입력해주세요 : ")
    val second = sc.nextInt()
    println("1. 더하기 / 2. 빼기 / 3. 곱하기 / 4. 나누기")
    print("연산을 선택해주세요 : ")
    val select: Int = sc.nextInt()

    when (select) {
        1 -> {
            print("더하기를 선택하셨습니다 -> ")
            println("결과값 : ${sum(first, second)}")
        }

        2 -> {
            print("빼기를 선택하셨습니다 -> ")
            println("결과값 : ${minus(first, second)}")
        }

        3 -> {
            print("곱하기를 선택하셨습니다 -> ")
            println("결과값 : ${multiply(first, second)}")
        }

        4 -> {
            print("나누기를 선택하셨습니다 -> ")
            println("결과값 : ${divide(first.toDouble(), second)}")
        }

        else -> {
            println("저희에게 없는 연산을 선택하셨습니다. (1 ~ 4 중에 선택하셔야 합니다.)")
        }
    }

    reEnd()
}

fun reEnd() {
    val sc = Scanner(System.`in`)
    println("1. 다시하기 / 2. 종료")
    print("입력해주세요 : ")
    val result = sc.nextInt()

    when (result) {
        1 -> calculator()
        2 -> println("종료합니다.")
        else -> return
    }
}


fun repeat(     // named argument
    str: String,
    num: Int = 3,
    useNewLine: Boolean = true
) {
    for (i in 1..num) {
        if (useNewLine) {
            println(str)
        } else {
            println(str)
        }
    }
}

fun printAll(vararg strings: String) {  // 가변인자 -> ...을 타입 뒤에 쓰는 대신 제일 앞에 vararg 를 적어주어야 함.
    for (str in strings) {
        println(str)
    }
}




/*
* 함수의 문법은 java 와 다르다
* body 가 하나의 값으로 간주되는 경우 {}block 을 없앨 수도 있고, {}block 이 없다면 반환 타입을 업앨 수도 있다.
* 함수 파라미터에 기본값을 설정해줄 수 있다.
* 함수를 호출할 때 특정 파라미터를 지정해 넣어줄 수 있다.
* 가변인자에는 vararg 키워드를 사용하며, 가변인자 함수를 배열과 호출할 때는 * 를 붙여줘야 한다.
 */