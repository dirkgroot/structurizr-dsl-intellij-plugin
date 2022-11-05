import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.20"
    java
    id("org.jetbrains.intellij") version "1.9.0"
    id("org.jetbrains.grammarkit") version "2021.2.1"
}

group = "nl.dirkgroot"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

// See https://github.com/JetBrains/gradle-intellij-plugin/
intellij {
    version.set("2022.2.3")
}

sourceSets["main"].java.srcDirs("src/main/gen")

dependencies {
    testImplementation("com.willowtreeapps.assertk:assertk-jvm:0.25")
}

tasks {
    withType<JavaCompile> {
        sourceCompatibility = "11"
        targetCompatibility = "11"
    }

    withType<KotlinCompile> {
        dependsOn("generateLexer")

        kotlinOptions {
            jvmTarget = "11"
        }
    }

    patchPluginXml {
        changeNotes.set(
            """
            Add change notes here.<br>
            <em>most HTML tags may be used</em>
            """.trimIndent()
        )
    }

    generateLexer {
        // source flex file
        source.set("src/main/grammar/StructurizrDSL.flex")

        // target directory for lexer
        targetDir.set("src/main/gen/nl/dirkgroot/structurizr/dsl/")

        // target classname, target file will be targetDir/targetClass.java
        targetClass.set("StructurizrDSLLexer")

        // if set, plugin will remove a lexer output file before generating new one. Default: false
        purgeOldFiles.set(true)
    }
}
