package com.android.com.kotlin.one

fun runTest(name: String, block: () -> Boolean) {
    try {
        check(block()) { "❌ Test failed: $name" }
        println("✅ $name")
    } catch (e: Throwable) {
        println("❌ $name → ${e.message}")
    }
}

// Exercise 1 — Immutable List
fun ex1CreateImmutableList(): List<Int> {
    return listOf(1, 2, 3, 4, 5)
}

// Exercise 2 — Mutable List
fun ex2CreateMutableList(): List<String> {
    val list = mutableListOf("Kotlin", "Java", "Python")
    list.add("Swift")
    return list
}

// Exercise 3 — Filter Even
fun ex3FilterEvenNumbers(): List<Int> {
    return (1..10).filter { it % 2 == 0 }
}

fun main() {
    //TODO("Pour cette leçon, suivez les instructions dans le fichier README_02.md")
    println("🔍 Running Kotlin List Processing Tests...\n")

    // Exercise 1
    runTest("ex1 - Immutable list has 5 elements") {
        ex1CreateImmutableList().size == 5
    }
    runTest("ex1 - List is immutable (List<Int>)") {
        ex1CreateImmutableList() is List<Int>
    }

    // Exercise 2
    runTest("ex2 - Mutable list has 4 elements after add") {
        ex2CreateMutableList().size == 4
    }
    runTest("ex2 - Last element is 'Swift'") {
        ex2CreateMutableList().last() == "Swift"
    }

    // Exercise 3
    runTest("ex3 - Even numbers from 1 to 10") {
        ex3FilterEvenNumbers() == listOf(2, 4, 6, 8, 10)
    }
}