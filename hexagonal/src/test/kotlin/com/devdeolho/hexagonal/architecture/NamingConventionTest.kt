package com.devdeolho.hexagonal.architecture

import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes

@AnalyzeClasses(packages = ["com.devdeolho.hexagonal"])
class NamingConventionTest {

    @ArchTest
    val `consumer reside only consumer package` = classes()
            .that()
            .haveNameMatching(".*Consumer")
            .should()
            .resideInAPackage("..adapters.in.consumer")
            .`as`("Consumer classes should reside inside consumer package in adapters.in package")

    @ArchTest
    val `message reside only message package` = classes()
            .that()
            .haveNameMatching(".*Message")
            .should()
            .resideInAPackage("..adapters.in.consumer.message")
            .`as`("Message classes should reside inside message package in consumer package")

    @ArchTest
    val `controller` = classes()
            .that()
            .haveNameMatching(".*Controller")
            .should()
            .resideInAPackage("..adapters.in.controller")
            .`as`("Controller classes should reside inside controller package in adapters.in package")

    @ArchTest
    val `request reside only request package` = classes()
            .that()
            .haveNameMatching(".*Request")
            .should()
            .resideInAnyPackage("..adapters.in.controller.request", "..adapters.out.client.request")
            .`as`("Request classes should reside inside request package in controller or client packages")

    @ArchTest
    val `response reside only response package` = classes()
            .that()
            .haveNameMatching(".*Response")
            .should()
            .resideInAnyPackage("..adapters.in.controller.response", "..adapters.out.client.response")
            .`as`("Response classes should reside inside response package in controller or client packages")

    @ArchTest
    val `adapter reside only adapter package` = classes()
            .that()
            .haveNameMatching(".*Adapter")
            .should()
            .resideInAPackage("..adapters.out")
            .`as`("Adapter classes should reside inside out package in adapters package")

    @ArchTest
    val `client reside only client package` = classes()
            .that()
            .haveNameMatching(".*Client")
            .should()
            .resideInAPackage("..adapters.out.client")
            .`as`("Client classes should reside inside client package in adapters.out package")

    @ArchTest
    val `repositoty reside only repository package` = classes()
            .that()
            .haveNameMatching(".*Repository")
            .should()
            .resideInAPackage("..adapters.out.repository")
            .`as`("Repository classes should reside inside repository package in adapters.out package")

    @ArchTest
    val `entity reside only entity package` = classes()
            .that()
            .haveNameMatching(".*Entity")
            .should()
            .resideInAPackage("..adapters.out.repository.entity")
            .`as`("Entity classes should reside inside entity package in entity package")

    @ArchTest
    val `usecase reside only usecase package` = classes()
            .that()
            .haveNameMatching(".*UseCase")
            .should()
            .resideInAPackage("..application.core.usecase")
            .`as`("Usecase classes should reside inside usecase package in core package")

    @ArchTest
    val `input reside only input package` = classes()
            .that()
            .haveNameMatching(".*InputPort")
            .should()
            .resideInAPackage("..application.ports.in")
            .`as`("InputPort classes should reside inside ports.in package in application package")

    @ArchTest
    val `output reside only output package` = classes()
            .that()
            .haveNameMatching(".*OutputPort")
            .should()
            .resideInAPackage("..application.ports.out")
            .`as`("OutputPort classes should reside inside ports.out package in application package")

    @ArchTest
    val `config reside only config package` = classes()
            .that()
            .haveNameMatching(".*Config")
            .should()
            .resideInAPackage("..hexagonal.config")
            .`as`("Config classes should reside inside config package in hexagonal package")
}
