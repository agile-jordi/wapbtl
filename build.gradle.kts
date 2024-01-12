plugins {
    kotlin("multiplatform") version "1.9.22"
}

group = "com.agilogy"
version = "0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
        testRuns["test"].executionTask.configure {
            useJUnit()
        }
    }
    js {
        browser {
            commonWebpackConfig {
                cssSupport { enabled = true }
            }
        }
    }
}

dependencies {
    commonTestImplementation(kotlin("test"))
}
