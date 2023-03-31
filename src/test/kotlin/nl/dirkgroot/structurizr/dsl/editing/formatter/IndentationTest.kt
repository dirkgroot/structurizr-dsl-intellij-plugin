package nl.dirkgroot.structurizr.dsl.editing.formatter

import org.junit.jupiter.api.Test

class IndentationTest : FormatterTest() {
    @Test
    fun `block with single line element`() {
        assertFormattingResult(
            """
                softwareSystem name description {
                container Backend
                }
            """.trimIndent(),
            """
                softwareSystem name description {
                    container Backend
                }
            """.trimIndent(),
        )
    }

    @Test
    fun `nested blocks`() {
        assertFormattingResult(
            """
                softwareSystem name description {
                container Backend {
                component RestAPI
                }
                }
            """.trimIndent(),
            """
                softwareSystem name description {
                    container Backend {
                        component RestAPI
                    }
                }
            """.trimIndent(),
        )
    }

    @Test
    fun `property block`() {
        assertFormattingResult(
            """
                properties {
                a b
                c d
                }
            """.trimIndent(),
            """
                properties {
                    a b
                    c d
                }
            """.trimIndent(),
        )
    }

    @Test
    fun `nested property block`() {
        assertFormattingResult(
            """
                softwareSystem system {
                properties {
                a b
                c d
                }
                }
            """.trimIndent(),
            """
                softwareSystem system {
                    properties {
                        a b
                        c d
                    }
                }
            """.trimIndent(),
        )
    }

    @Test
    fun `block with assigned identifier`() {
        assertFormattingResult(
            """
                systemIdentifier = softwareSystem system {
                container backend
                }
            """.trimIndent(),
            """
                systemIdentifier = softwareSystem system {
                    container backend
                }
            """.trimIndent(),
        )
    }

    @Test
    fun `script block`() {
        assertFormattingResult(
            """
                !script kotlin {
                println("Hello World")
                }
            """.trimIndent(),
            """
                !script kotlin {
                println("Hello World")
                }
            """.trimIndent(),
        )
    }

    @Test
    fun `nested script block`() {
        assertFormattingResult(
            """
                workspace {
                !script kotlin {
                println("Hello World")
                }
                }
            """.trimIndent(),
            """
                workspace {
                    !script kotlin {
                println("Hello World")
                }
                }
            """.trimIndent(),
        )
    }

    @Test
    fun `explicit relationships`() {
        assertFormattingResult(
            """
                model {
                    a = softwareSystem A
                    b = softwareSystem B
                a -> b Uses
                }
            """.trimIndent(),
            """
                model {
                    a = softwareSystem A
                    b = softwareSystem B
                    a -> b Uses
                }
            """.trimIndent()
        )
    }

    @Test
    fun `implicit relationships`() {
        assertFormattingResult(
            """
                model {
                    a = softwareSystem A
                    b = softwareSystem B {
                    -> a Uses
                    }
                }
            """.trimIndent(),
            """
                model {
                    a = softwareSystem A
                    b = softwareSystem B {
                        -> a Uses
                    }
                }
            """.trimIndent()
        )
    }

    @Test
    fun `line comments`() {
        assertFormattingResult(
            """
                model {
                # comment
                }
            """.trimIndent(),
            """
                model {
                    # comment
                }
            """.trimIndent()
        )
    }

    @Test
    fun `block comments`() {
        assertFormattingResult(
            """
                model {
                /*
                comment
                */
                }
            """.trimIndent(),
            """
                model {
                    /*
                    comment
                    */
                }
            """.trimIndent()
        )
    }

    @Test
    fun `identifier references`() {
        assertFormattingResult(
            """
                animation {
                a b c
                d
                }
            """.trimIndent(),
            """
                animation {
                    a b c
                    d
                }
            """.trimIndent()
        )
    }
}
