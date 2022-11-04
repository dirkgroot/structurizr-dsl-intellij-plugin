package nl.dirkgroot.structurizr.dsl

import assertk.assertThat
import assertk.assertions.isEqualTo
import nl.dirkgroot.structurizr.dsl.psi.SDWorkspace
import org.junit.Test

class ParseWorkspaceTest : StructurizrDSLParserTest() {
    @Test
    fun `plain workspace keyword`() {
        assertParseSucceeds(
            "workspace"
        )
    }

    @Test
    fun `empty workspace`() {
        assertParseSucceeds(
            """
            workspace {
            }
            """.trimIndent()
        )
    }

    @Test
    fun `workspace with name`() {
        val file = assertParseSucceeds(
            """
            workspace "Workspace name" {
            }
            """.trimIndent()
        )
        val workspace = file.children.filterIsInstance<SDWorkspace>().single()
        assertThat(workspace.elementName).isEqualTo("Workspace name")
    }

    @Test
    fun `workspace with name and description`() {
        val file = assertParseSucceeds(
            """
            workspace "Workspace name" "Workspace description" {
            }
            """.trimIndent()
        )
        val workspace = file.children.filterIsInstance<SDWorkspace>().single()
        assertThat(workspace.elementDescription).isEqualTo("Workspace description")
    }

    @Test
    fun `workspace with model section`() {
        assertParseSucceeds(
            """
            workspace {
                model {
                }
            }
            """.trimIndent()
        )
    }

    @Test
    fun `workspace with model and views section`() {
        assertParseSucceeds(
            """
            workspace {
                model {
                }
                views {
                }
            }
            """.trimIndent()
        )
        assertParseSucceeds(
            """
            workspace {
                views {
                }
                model {
                }
            }
            """.trimIndent()
        )
    }

    @Test
    fun `workspace with views section`() {
        assertParseSucceeds(
            """
            workspace {
                views {
                }
            }
            """.trimIndent()
        )
    }

    @Test
    fun `allow max 1 workspace`() {
        assertParseFails(
            """
            workspace {
            }
            workspace {
            }
            """.trimIndent()
        )
    }

    @Test
    fun `max 1 model section`() {
        assertParseFails(
            """
            workspace {
                model {
                }
                model {
                }
            }
            """.trimIndent()
        )
    }

    @Test
    fun `max 1 views section`() {
        assertParseFails(
            """
            workspace {
                views {
                }
                views {
                }
            }
            """.trimIndent()
        )
    }
}
