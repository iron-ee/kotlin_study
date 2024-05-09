package main.kotlin.loop

import java.util.Scanner

fun loop() {
    // 반복문
    // 대중적인 for 문과 while 문이 있다.

    // for
    // 1 ~ 10 까지 실행
    for(index: Int in 1..10) {
        println("(1) index = $index")
    }

    // 1 ~ 9 까지 실행
    for(index: Int in 1 until 10) {
        println("(2) index = $index")
    }

    // 1, 3, 5, 7, 9 실행
    for(index: Int in 1..10 step(2)) {
        println("(3) index = $index")
    }

    // 10 ~ 1 까지 실행
    for(index: Int in 10 downTo 1) {
        println("(4) index = $index")
    }

    // 10, 8, 6, 4, 2 실행
    for(index: Int in 10 downTo 1 step(2)) {
        println("(5) index = $index")
    }

    ///////////////////////////////////////

    // while
    var count1 = 0
    while (count1 <= 10) {
        println("(while 1) count = $count1")
        count1++
    }

    ///////////////////////////////////////

    // 반복문 제어
    // break, continue

    // break (반복문 즉시 종료)
    var count2 = 0
    while (count2 <= 10) {
        if (count2 == 5) {
            break
        }
        println("(break 1) count = $count2")
        count2++
    }

    for (index: Int in 0..10) {
        if (index == 5) {
            break
        }
        println("(break 2) index = $index")
    }

    ///////////////////////////////////////

    // continue (해당 continue 아래 나머지 코드 스킵되고 다음 반복으로 진행)
    var count3 = 0
    while (count3 <= 10) {
        count3++
        if (count3 == 5) {
            continue
        }

        println("(continue 1) count = $count3")
    }

    for (index: Int in 0..10) {
        if (index == 5) {
            continue
        }

        println("(continue 2) index = $index")
    }

    ///////////////////////////////////////

    // 반복문 연습 예제
    // 입력받은 수 만큼의 층으로 * 피라미드 만들기
    val sc = Scanner(System.`in`)
    println("줄 수를 입력해주세요 : ")
    val line = sc.nextInt()

    for (row: Int in 1..line) {
        for (space: Int in line - row downTo 1) {
            print(" ")
        }
        for (star: Int in 1 until row * 2) {
            print("*")
        }
        println()
    }
}