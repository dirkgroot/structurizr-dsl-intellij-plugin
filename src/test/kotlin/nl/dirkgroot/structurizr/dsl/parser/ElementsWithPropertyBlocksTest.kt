package nl.dirkgroot.structurizr.dsl.parser

import nl.dirkgroot.structurizr.dsl.lexer.KEYWORDS_WITH_PROPERTY_BLOCKS
import nl.dirkgroot.structurizr.dsl.support.StructurizrDSLCodeInsightTest
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class ElementsWithPropertyBlocksTest(private val keyword: String) : StructurizrDSLCodeInsightTest() {
    companion object {
        @Parameterized.Parameters
        @JvmStatic
        fun keywords(): Collection<Array<Any>> =
            KEYWORDS_WITH_PROPERTY_BLOCKS.map { (keyword, _) -> arrayOf(keyword) }
    }

    @Test
    fun `empty block`() {
        assertPsiTree(
            """
                $keyword {
                }
            """.trimIndent(),
            """
                PropertiesStatement
                    PropertiesKeyword $keyword
                    PropertiesBlock {\n}
            """.trimIndent()
        )
    }

    @Test
    fun `block with only empty lines inside`() {
        assertPsiTree(
            """
                $keyword {



                }
            """.trimIndent(),
            """
                PropertiesStatement
                    PropertiesKeyword $keyword
                    PropertiesBlock {\n\n\n\n}
            """.trimIndent()
        )
    }

    @Test
    fun `block with line comment inside`() {
        assertPsiTree(
            """
                $keyword {
                    // line comment
                }
            """.trimIndent(),
            """
                PropertiesStatement
                    PropertiesKeyword $keyword
                    PropertiesBlock {\n    // line comment\n}
            """.trimIndent()
        )
    }

    @Test
    fun `block with block comment inside`() {
        assertPsiTree(
            """
                $keyword {
                    /* block comment */
                }
            """.trimIndent(),
            """
                PropertiesStatement
                    PropertiesKeyword $keyword
                    PropertiesBlock {\n    /* block comment */\n}
            """.trimIndent()
        )
    }

    @Test
    fun `block with single property inside`() {
        assertPsiTree(
            """
                $keyword {
                    key value
                }
            """.trimIndent(),
            """
                PropertiesStatement
                    PropertiesKeyword $keyword
                    PropertiesBlock
                        PropertyDefinition
                            PropertyDefinitionPart key
                            PropertyDefinitionPart value
            """.trimIndent()
        )
    }

    @Test
    fun `block with incomplete property inside`() {
        assertPsiTree(
            """
                $keyword {
                    key
                }
            """.trimIndent(),
            """
                PropertiesStatement
                    PropertiesKeyword $keyword
                    PropertiesBlock
                        PropertyDefinition
                            PropertyDefinitionPart key
            """.trimIndent()
        )
    }

    @Test
    fun `block with overcomplete property inside`() {
        assertPsiTree(
            """
                $keyword {
                    key value extra
                }
            """.trimIndent(),
            """
                PropertiesStatement
                    PropertiesKeyword $keyword
                    PropertiesBlock
                        PropertyDefinition
                            PropertyDefinitionPart key
                            PropertyDefinitionPart value
                            PropertyDefinitionPart extra
            """.trimIndent()
        )
    }

    @Test
    fun `block with multiple properties inside`() {
        assertPsiTree(
            """
                $keyword {
                    key1 value1
                    key2 "value 2"
                    "key 3" value3
                    "key 4" "value 4"
                }
            """.trimIndent(),
            """
                PropertiesStatement
                    PropertiesKeyword $keyword
                    PropertiesBlock
                        PropertyDefinition
                            PropertyDefinitionPart key1
                            PropertyDefinitionPart value1
                        PropertyDefinition
                            PropertyDefinitionPart key2
                            PropertyDefinitionPart "value 2"
                        PropertyDefinition
                            PropertyDefinitionPart "key 3"
                            PropertyDefinitionPart value3
                        PropertyDefinition
                            PropertyDefinitionPart "key 4"
                            PropertyDefinitionPart "value 4"
            """.trimIndent()
        )
    }
}
