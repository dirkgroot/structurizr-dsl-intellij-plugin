package nl.dirkgroot.structurizr.dsl.editing.completion

import com.intellij.codeInsight.completion.CompletionType
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.collections.shouldNotContain
import io.kotest.matchers.shouldBe
import nl.dirkgroot.structurizr.dsl.support.StructurizrDSLCodeInsightTest

class SDCompletionTest : StructurizrDSLCodeInsightTest() {

    fun `test top-level offers workspace`() {
        complete("<caret>") shouldContain "workspace"
    }

    fun `test top-level does not offer block-only keywords`() {
        val result = complete("<caret>")
        result shouldNotContain "model"
        result shouldNotContain "softwareSystem"
    }

    fun `test inside workspace`() {
        val result = complete(
            """
                workspace {
                    <caret>
                }
            """.trimIndent()
        )
        result shouldContainAll listOf("model", "views", "configuration", "!identifiers", "!docs", "!script")
    }

    fun `test inside model`() {
        val result = complete(
            """
                workspace {
                    model {
                        <caret>
                    }
                }
            """.trimIndent()
        )
        result shouldContainAll listOf("softwareSystem", "person", "enterprise", "deploymentEnvironment", "group")
    }

    fun `test inside softwareSystem`() {
        val result = complete(
            """
                workspace {
                    model {
                        softwareSystem "S" {
                            <caret>
                        }
                    }
                }
            """.trimIndent()
        )
        result shouldContainAll listOf("container", "description", "tags", "url", "properties", "!docs")
    }

    fun `test inside container`() {
        val result = complete(
            """
                workspace {
                    model {
                        softwareSystem "S" {
                            container "C" {
                                <caret>
                            }
                        }
                    }
                }
            """.trimIndent()
        )
        result shouldContainAll listOf("component", "description", "technology", "tags")
    }

    fun `test inside views`() {
        val result = complete(
            """
                workspace {
                    views {
                        <caret>
                    }
                }
            """.trimIndent()
        )
        result shouldContainAll listOf("systemContext", "container", "dynamic", "styles", "theme", "branding")
    }

    fun `test inside styles offers element and relationship`() {
        val result = complete(
            """
                workspace {
                    views {
                        styles {
                            <caret>
                        }
                    }
                }
            """.trimIndent()
        )
        result shouldContainAll listOf("element", "relationship")
    }

    fun `test inside styles element offers visual properties`() {
        val result = complete(
            """
                workspace {
                    views {
                        styles {
                            element "Software System" {
                                <caret>
                            }
                        }
                    }
                }
            """.trimIndent()
        )
        result shouldContainAll listOf("background", "color", "shape", "border", "fontSize")
    }

    fun `test inside styles relationship offers relationship properties`() {
        val result = complete(
            """
                workspace {
                    views {
                        styles {
                            relationship "Relationship" {
                                <caret>
                            }
                        }
                    }
                }
            """.trimIndent()
        )
        result shouldContainAll listOf("thickness", "color", "opacity", "routing", "dashed")
    }

    fun `test inside deploymentEnvironment`() {
        val result = complete(
            """
                workspace {
                    model {
                        deploymentEnvironment "Live" {
                            <caret>
                        }
                    }
                }
            """.trimIndent()
        )
        result shouldContainAll listOf("deploymentNode", "deploymentGroup")
    }

    fun `test prefix filters results to matching keywords only`() {
        val result = complete(
            """
                workspace {
                    views {
                        styles {
                            element "Software System" {
                                b<caret>
                            }
                        }
                    }
                }
            """.trimIndent()
        )
        result shouldContainAll listOf("background", "border")
        result.forEach { it.lowercase().startsWith("b") shouldBe true }
    }

    fun `test single-match prefix auto-completes`() {
        myFixture.configureByText(
            "test.dsl",
            """
                workspace {
                    mo<caret>
                }
            """.trimIndent()
        )
        myFixture.complete(CompletionType.BASIC)
        myFixture.checkResult(
            """
                workspace {
                    model<caret>
                }
            """.trimIndent()
        )
    }

    fun `test case-insensitive prefix matching`() {
        val result = complete(
            """
                workspace {
                    views {
                        styles {
                            element "Software System" {
                                B<caret>
                            }
                        }
                    }
                }
            """.trimIndent()
        )
        result shouldContainAll listOf("background", "border")
    }

    fun `test bare element outside styles does not get style properties`() {
        val result = complete(
            """
                workspace {
                    model {
                        element "X" {
                            <caret>
                        }
                    }
                }
            """.trimIndent()
        )
        result shouldNotContain "background"
        result shouldNotContain "shape"
    }

    private fun complete(source: String): List<String> {
        myFixture.configureByText("test.dsl", source)
        myFixture.complete(CompletionType.BASIC)
        return myFixture.lookupElementStrings.orEmpty()
    }
}
