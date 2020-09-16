buildscript {
    val kotlinVersion by extra("1.4.10")
    val sqlDelightVersion by extra("1.4.2")

    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath(kotlin("gradle-plugin", version = kotlinVersion))
        classpath(kotlin("serialization", version = kotlinVersion))
        classpath("com.android.tools.build:gradle:4.0.1")
        classpath("com.squareup.sqldelight:gradle-plugin:$sqlDelightVersion")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}