import org.jetbrains.dokka.gradle.DokkaTask

plugins {
    id("org.jetbrains.dokka")
    `java-test-fixtures`
}

dependencies {
    implementation("org.yaml:snakeyaml")
    api(kotlin("compiler-embeddable"))
    api(project(":detekt-psi-utils"))

    testImplementation(project(":detekt-parser"))
    testImplementation(project(":detekt-test"))

    testFixturesApi(kotlin("stdlib-jdk8"))
}

tasks.withType<DokkaTask>().configureEach {
    outputFormat = "jekyll"
    outputDirectory = "$rootDir/docs/pages/kdoc"
    configuration {
        moduleName = project.name
        reportUndocumented = false
        @Suppress("MagicNumber")
        jdkVersion = 8
    }
}
