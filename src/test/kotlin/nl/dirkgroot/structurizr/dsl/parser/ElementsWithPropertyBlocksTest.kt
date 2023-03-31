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
                    PropertyBlockStatement
                        KeywordWithPropertyBlock $keyword
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
                    PropertyBlockStatement
                        KeywordWithPropertyBlock $keyword
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
                    PropertyBlockStatement
                        KeywordWithPropertyBlock $keyword
                        KeyValuePair
                            Key key
                            Value value
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
                    PropertyBlockStatement
                        KeywordWithPropertyBlock $keyword
                        KeyValuePair
                            Key key1
                            Value value1
                        KeyValuePair
                            Key key2
                            Value "value 2"
                        KeyValuePair
                            Key "key 3"
                            Value value3
                        KeyValuePair
                            Key "key 4"
                            Value "value 4"
                """.trimIndent()
            )
        }
    }
}
