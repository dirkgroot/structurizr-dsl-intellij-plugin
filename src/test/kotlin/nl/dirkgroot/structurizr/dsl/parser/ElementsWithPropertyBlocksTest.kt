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
                    PropertiesDefinition
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
                    PropertiesDefinition
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
                    PropertiesDefinition
                        PropertiesKeyword $keyword
                        PropertiesBlock
                            PropertyDefinition
                                PropertyKey key
                                PropertyValue value
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
                    PropertiesDefinition
                        PropertiesKeyword $keyword
                        PropertiesBlock
                            PropertyDefinition
                                PropertyKey key1
                                PropertyValue value1
                            PropertyDefinition
                                PropertyKey key2
                                PropertyValue "value 2"
                            PropertyDefinition
                                PropertyKey "key 3"
                                PropertyValue value3
                            PropertyDefinition
                                PropertyKey "key 4"
                                PropertyValue "value 4"
                """.trimIndent()
            )
        }
    }
}
