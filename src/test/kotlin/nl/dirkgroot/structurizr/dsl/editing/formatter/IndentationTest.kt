package nl.dirkgroot.structurizr.dsl.editing.formatter

class IndentationTest : FormatterTest() {
    fun `test block with single line element`() {
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

    fun `test nested blocks`() {
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

    fun `test property block`() {
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

    fun `test nested property block`() {
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

    fun `test block with assigned identifier`() {
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

    fun `test script block`() {
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

    fun `test nested script block`() {
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

    fun `test explicit relationships`() {
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

    fun `test implicit relationships`() {
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

    fun `test line comments`() {
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

    fun `test block comments`() {
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

    fun `test identifier references`() {
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
