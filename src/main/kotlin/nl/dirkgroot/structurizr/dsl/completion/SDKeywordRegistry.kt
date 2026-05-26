package nl.dirkgroot.structurizr.dsl.completion

import nl.dirkgroot.structurizr.dsl.completion.SDCompletionContext.*

object SDKeywordRegistry {

    private val commonElementChildren = listOf(
        keyword("description"),
        keyword("technology"),
        keyword("tags"),
        keyword("url"),
        keyword("properties"),
        keyword("perspectives"),
        directive("!docs"),
        directive("!adrs"),
    )
    
    private val styleVisualProperties = listOf(
        keyword("background"),
        keyword("color"),
        keyword("colour"),
        keyword("shape"),
        keyword("icon"),
        keyword("border"),
        keyword("stroke"),
        keyword("strokeWidth"),
        keyword("opacity"),
        keyword("fontSize"),
        keyword("width"),
        keyword("height"),
        keyword("metadata"),
        keyword("description"),
        keyword("properties"),
    )

    private val data: Map<SDCompletionContext, List<SDKeywordInfo>> = mapOf(
        TOP_LEVEL to listOf(
            keyword("workspace"),
        ),
        WORKSPACE to listOf(
            keyword("model"),
            keyword("views"),
            keyword("configuration"),
            keyword("name"),
            keyword("description"),
            keyword("properties"),
            directive("!identifiers"),
            directive("!docs"),
            directive("!adrs"),
            directive("!constant"),
            directive("!impliedRelationships"),
            directive("!include"),
            directive("!plugin"),
            directive("!script"),
        ),
        MODEL to listOf(
            keyword("softwareSystem"),
            keyword("person"),
            keyword("enterprise"),
            keyword("group"),
            keyword("deploymentEnvironment"),
            keyword("element"),
            keyword("properties"),
            directive("!ref"),
            directive("!include"),
        ),
        ENTERPRISE to listOf(
            keyword("softwareSystem"),
            keyword("person"),
            keyword("group"),
        ),
        GROUP to listOf(
            keyword("softwareSystem"),
            keyword("person"),
            keyword("container"),
            keyword("component"),
            keyword("group"),
        ),
        SOFTWARE_SYSTEM to (
            listOf(
                keyword("container"),
                keyword("group"),
            ) + commonElementChildren
            ),
        CONTAINER to (
            listOf(
                keyword("component"),
                keyword("group"),
            ) + commonElementChildren
            ),
        COMPONENT to commonElementChildren,
        PERSON to commonElementChildren,
        DEPLOYMENT_ENVIRONMENT to listOf(
            keyword("deploymentNode"),
            keyword("deploymentGroup"),
            keyword("group"),
            keyword("properties"),
        ),
        DEPLOYMENT_NODE to listOf(
            keyword("deploymentNode"),
            keyword("infrastructureNode"),
            keyword("containerInstance"),
            keyword("softwareSystemInstance"),
            keyword("group"),
            keyword("description"),
            keyword("technology"),
            keyword("instances"),
            keyword("tags"),
            keyword("url"),
            keyword("properties"),
            keyword("perspectives"),
        ),
        INFRASTRUCTURE_NODE to listOf(
            keyword("description"),
            keyword("technology"),
            keyword("tags"),
            keyword("url"),
            keyword("properties"),
            keyword("perspectives"),
        ),
        CONTAINER_INSTANCE to listOf(
            keyword("description"),
            keyword("tags"),
            keyword("url"),
            keyword("healthCheck"),
            keyword("properties"),
            keyword("perspectives"),
        ),
        SOFTWARE_SYSTEM_INSTANCE to listOf(
            keyword("description"),
            keyword("tags"),
            keyword("url"),
            keyword("healthCheck"),
            keyword("properties"),
            keyword("perspectives"),
        ),
        VIEWS to (
            listOf(
                keyword("systemLandscape"),
                keyword("systemContext"),
                keyword("container"),
                keyword("component"),
                keyword("dynamic"),
                keyword("deployment"),
                keyword("filtered"),
                keyword("custom"),
                keyword("image"),
                keyword("styles"),
                keyword("theme"),
                keyword("themes"),
                keyword("branding"),
                keyword("terminology"),
                keyword("configuration"),
                keyword("properties"),
                directive("!include"),
                directive("!script"),
            )
            ),
        CONFIGURATION to listOf(
            keyword("users"),
            keyword("visibility"),
            keyword("scope"),
            keyword("properties"),
        ),
        BRANDING to listOf(
            keyword("logo"),
            keyword("font"),
        ),
        TERMINOLOGY to listOf(
            keyword("person"),
            keyword("softwareSystem"),
            keyword("container"),
            keyword("component"),
            keyword("deploymentNode"),
            keyword("infrastructureNode"),
            keyword("relationship"),
            keyword("enterprise"),
        ),
        STYLES to listOf(
            keyword("element"),
            keyword("relationship"),
        ),
        STYLES_ELEMENT to styleVisualProperties,
        STYLES_RELATIONSHIP to listOf(
            keyword("thickness"),
            keyword("color"),
            keyword("colour"),
            keyword("opacity"),
            keyword("fontSize"),
            keyword("width"),
            keyword("dashed"),
            keyword("style"),
            keyword("routing"),
            keyword("position"),
            keyword("properties"),
        ),
        UNKNOWN to emptyList(),
    )

    fun keywordsFor(context: SDCompletionContext): List<SDKeywordInfo> = data[context].orEmpty()

    private fun keyword(text: String) = SDKeywordInfo(text, typeText = "keyword")
    private fun directive(text: String) = SDKeywordInfo(text, typeText = "directive")
}
