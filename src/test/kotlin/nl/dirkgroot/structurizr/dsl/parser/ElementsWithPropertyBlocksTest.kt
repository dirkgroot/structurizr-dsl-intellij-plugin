package nl.dirkgroot.structurizr.dsl.parser

import nl.dirkgroot.structurizr.dsl.lexer.KEYWORDS_WITH_PROPERTY_BLOCKS
import nl.dirkgroot.structurizr.dsl.support.StructurizrDSLCodeInsightTest
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory

class ElementsWithPropertyBlocksTest : StructurizrDSLCodeInsightTest() {
    @TestFactory
    fun `empty block`() = KEYWORDS_WITH_PROPERTY_BLOCKS.map { (keyword, _) ->
        dynamicTest(keyword) {
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
    }

    @TestFactory
    fun `block with only empty lines inside`() = KEYWORDS_WITH_PROPERTY_BLOCKS.map { (keyword, _) ->
        dynamicTest(keyword) {
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
    }

    @TestFactory
    fun `block with single property inside`() = KEYWORDS_WITH_PROPERTY_BLOCKS.map { (keyword, _) ->
        dynamicTest(keyword) {
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
    }

    @TestFactory
    fun `block with incomplete property inside`() = KEYWORDS_WITH_PROPERTY_BLOCKS.map { (keyword, _) ->
        dynamicTest(keyword) {
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
    }

    @TestFactory
    fun `block with overcomplete property inside`() = KEYWORDS_WITH_PROPERTY_BLOCKS.map { (keyword, _) ->
        dynamicTest(keyword) {
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
    }

    @TestFactory
    fun `block with multiple properties inside`() = KEYWORDS_WITH_PROPERTY_BLOCKS.map { (keyword, _) ->
        dynamicTest(keyword) {
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
}
