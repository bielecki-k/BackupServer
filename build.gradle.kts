plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("com.google.guava:guava:32.1.3-jre")
    implementation("org.springframework.boot:spring-boot-starter:3.2.0")


}

tasks.test {
    useJUnitPlatform()
}