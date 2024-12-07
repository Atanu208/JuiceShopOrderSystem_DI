
plugins {
    // Apply the java-library plugin for API and implementation separation.
    `java-library`
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    // https://mvnrepository.com/artifact/org.springframework/spring-context-support
    implementation("org.springframework:spring-context-support:6.2.0")
// https://mvnrepository.com/artifact/org.springframework/spring-jdbc
    implementation("org.springframework:spring-jdbc:6.2.0")
// https://mvnrepository.com/artifact/org.springframework/spring-tx
    implementation("org.springframework:spring-tx:6.2.0")
// https://mvnrepository.com/artifact/com.mysql/mysql-connector-j
    implementation("com.mysql:mysql-connector-j:9.1.0")

}
