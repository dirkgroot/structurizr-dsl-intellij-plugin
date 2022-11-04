package nl.dirkgroot.structurizr.dsl

import assertk.assertThat
import assertk.assertions.containsAll
import assertk.assertions.isEqualTo
import nl.dirkgroot.structurizr.dsl.psi.SDElementWithDescription
import nl.dirkgroot.structurizr.dsl.psi.SDElementWithName
import nl.dirkgroot.structurizr.dsl.psi.SDSoftwareSystem
import org.junit.Test

class ParseSoftwareSystemTest : StructurizrDSLParserTest() {
    @Test
    fun `software system with a name`() {
        listOf(
            "\"Quoted name\"",
            "unquoted/name/but/no/identifier",
            "unquoted_name_which_qualifies_as_an_identifier",
        ).forEach { name ->
            val file = assertParseSucceeds(
                """
                softwareSystem $name
                """.trimIndent()
            )
            val softwareSystemElement = file.children[0] as SDElementWithName
            assertThat(softwareSystemElement.elementName).isEqualTo(name.trim('"'))
        }
    }

    @Test
    fun `software system with a name and description`() {
        listOf(
            "\"Quoted description\"",
            "unquoted/description/but/no/identifier",
            "unquoted_description_which_qualifies_as_an_identifier",
        ).forEach { description ->
            val file = assertParseSucceeds(
                """
                softwareSystem "System name" $description
                """.trimIndent()
            )
            val softwareSystemElement = file.children[0] as SDElementWithDescription
            assertThat(softwareSystemElement.elementDescription).isEqualTo(description.trim('"'))
        }
    }

    @Test
    fun `software system with a name and description and tags`() {
        val file = assertParseSucceeds(
            """
            softwareSystem "System name" "System description" "quoted tag"
            softwareSystem "System name" "System description" "quoted_tag"
            softwareSystem "System name" "System description" "quoted_tag1,quoted tag2"
            softwareSystem "System name" "System description" "quoted_tag1, quoted tag2"
            softwareSystem "System name" "System description" unquoted_tag
            softwareSystem "System name" "System description" unquoted_tag1,unquoted_tag2
            """.trimIndent()
        )
        val softwareSystems = file.children.filterIsInstance<SDSoftwareSystem>()

        assertThat(softwareSystems[0].elementTags).containsAll("quoted tag")
        assertThat(softwareSystems[1].elementTags).containsAll("quoted_tag")
        assertThat(softwareSystems[2].elementTags).containsAll("quoted_tag1", "quoted tag2")
        assertThat(softwareSystems[3].elementTags).containsAll("quoted_tag1", "quoted tag2")
        assertThat(softwareSystems[4].elementTags).containsAll("unquoted_tag")
        assertThat(softwareSystems[5].elementTags).containsAll("unquoted_tag1", "unquoted_tag2")
    }
}
