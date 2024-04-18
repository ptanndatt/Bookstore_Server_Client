plugins {
    `java-library`
    `maven-publish`
}



repositories {
    mavenLocal()
    maven {
        url = uri("https://repo.maven.apache.org/maven2/")
    }
}
dependencies {
//   	api(libs.net.sf.jasperreports.jasperreports)
//    api(libs.org.springframework.security.spring.security.core)
//    api(libs.org.mindrot.jbcrypt)
//    api(libs.org.jfree.jfreechart)
//    api(libs.org.apache.logging.log4j.log4j.core)
//    api(libs.org.apache.poi.poi)
//    api(libs.org.apache.poi.poi.ooxml)
//    api(libs.org.apache.maven.plugins.maven.jar.plugin)
//    api(libs.com.toedter.jcalendar)
//    api(libs.org.apache.commons.commons.lang3)
//    api(libs.org.kordamp.ikonli.ikonli.swing)
//    api(libs.org.kordamp.ikonli.ikonli.materialdesign.pack)
//    api(libs.com.itextpdf.itextpdf)
    implementation("org.hibernate:hibernate-core:6.4.4.Final")
    testImplementation("org.hibernate.orm:hibernate-testing:6.4.4.Final")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.2")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.9.2")
    compileOnly("org.projectlombok:lombok:1.18.24")
    annotationProcessor("org.projectlombok:lombok:1.18.24")

    testCompileOnly("org.projectlombok:lombok:1.18.24")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.24")
    implementation("log4j:log4j:1.2.17")
    implementation("org.apache.logging.log4j:log4j-api:2.17.1")
    implementation("org.apache.logging.log4j:log4j-core:2.17.1")
    implementation("com.microsoft.sqlserver:mssql-jdbc:11.2.2.jre17")
}

group = "vn.N10_PTUD_v1"
version = "0.0.1-SNAPSHOT"
description = "QuanLyHieuSach"
java.sourceCompatibility = JavaVersion.VERSION_1_8

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
    }
}

tasks.withType<JavaCompile>() {
    options.encoding = "UTF-8"
}

tasks.withType<Javadoc>() {
    options.encoding = "UTF-8"
}

tasks.test {
    useJUnitPlatform()
    include("**/*Test.*")
}
