[![Build](https://github.com/dirkgroot/structurizr-dsl-intellij-plugin/actions/workflows/build.yml/badge.svg)](https://github.com/dirkgroot/structurizr-dsl-intellij-plugin/actions/workflows/build.yml)
[![GitHub release (latest SemVer including pre-releases)](https://img.shields.io/github/v/release/dirkgroot/structurizr-dsl-intellij-plugin?include_prereleases&label=latest%20release)](https://github.com/dirkgroot/structurizr-dsl-intellij-plugin/releases)

<!-- TOC -->
* [IntelliJ plugin for the Structurizr DSL](#intellij-plugin-for-the-structurizr-dsl)
  * [Features](#features)
  * [Decisions / limitations](#decisions--limitations)
  * [Installation](#installation)
  * [TODO](#todo)
    * [Legend](#legend)
    * [Features](#features-1)
    * [Grammar](#grammar)
<!-- TOC -->

# IntelliJ plugin for the Structurizr DSL

<!-- Plugin description -->

Adds [Structurizr DSL](https://github.com/structurizr/dsl/blob/master/docs/language-reference.md) language support to
IntelliJ.

Structurizr DSL is a domain specific language for creating architecture models and diagrams
using [Simon Brown](https://twitter.com/simonbrown)'s [C4 model](https://c4model.com).

> **Note**
>
> This plugin is in **alpha** stage, so there will likely be bugs. I'd love to get your feedback! You can leave feedback
> by [writing a review](https://plugins.jetbrains.com/plugin/20606-structurizr-dsl-language-support/reviews) or
> by [filing an issue](https://github.com/dirkgroot/structurizr-dsl-intellij-plugin/issues).

## Features

* Basic syntax highlighting for the Structurizr DSL language. Files with the `.dsl` extension are considered to be
  Structurizr DSL files.
* More to come! Please refer to the [TODO section](https://github.com/dirkgroot/structurizr-dsl-intellij-plugin#todo) of
  the README for a list of features that will likely be added.

## Decisions / limitations

- For now, arguments of statements are all treated as (un)quoted strings, so "true", "false", integers, (un)quoted text
  will all get the same syntax highlighting.
- The following blocks are treated as property blocks, containing (un)quoted string pairs:
    - branding
    - terminology
    - configuration
    - users
- All arguments of view declarations are highlighted as (un)quoted strings. Correct highlighting of these arguments will
  most likely be implemented using
  an [annotator](https://plugins.jetbrains.com/docs/intellij/syntax-highlighting-and-error-highlighting.html#annotator),
  instead of via lexer based highlighting.

<!-- Plugin description end -->

## Installation

- Add the `alpha` release channel to IntelliJ by adding the following url to the list of plugin
  repositories: <https://plugins.jetbrains.com/plugins/alpha/list>. Please refer to
  IntelliJ's [documentation](https://www.jetbrains.com/help/idea/managing-plugins.html#repos) for instructions on how to
  add plugin repositories.
- Search for "Structurizr" in the marketplace, and install the plugin. Please refer to
  IntelliJ's [documentation](https://www.jetbrains.com/help/idea/managing-plugins.html) for instructions on how to
  install plugins.

## TODO

### Legend

- 🔳 = todo
- ☑️ = partially done
- ✅ = done

### Features

- ☑️ syntax highlighting
    - ✅ token based
    - 🔳 annotator based
- 🔳 code validation
- 🔳 code competion
- 🔳 go to definition
- 🔳 diagram preview
- ...

### Grammar

- 🔳 `!include`
- 🔳 `!constant`
- 🔳️ `workspace`
    - 🔳 with children
    - 🔳 without children
    - 🔳 `name`
        - 🔳 argument
        - 🔳 child keyword
    - 🔳 `description`
        - 🔳 argument
        - 🔳 child keyword
    - 🔳 `extends`
    - 🔳 `properties`
    - 🔳 `!docs`
    - 🔳 `!adrs`
    - 🔳 `!identifiers`
    - 🔳 `!impliedRelationships`
    - 🔳 `model`
        - 🔳 with children
        - 🔳 without children
        - 🔳 identifiers
            - 🔳 flat
            - 🔳 hierarchical
        - 🔳 `group` (containing people, software systems)
        - 🔳 `person`
            - 🔳 `name`
                - 🔳 argument
                - 🔳 child keyword
            - 🔳 `description`
                - 🔳 argument
                - 🔳 child keyword
            - 🔳 `tags`
                - 🔳 argument
                - 🔳 child keyword
            - 🔳 `url`
            - 🔳 `properties`
            - 🔳 `perspectives`
            - 🔳 relationships
        - 🔳 `softwareSystem`
            - 🔳 `name`
                - 🔳 argument
                - 🔳 child keyword
            - 🔳 `description`
                - 🔳 argument
                - 🔳 child keyword
            - 🔳 `tags`
                - 🔳 argument
                - 🔳 child keyword
            - 🔳 `group` (containing containers)
            - 🔳 `container`
                - 🔳 `name`
                    - 🔳 argument
                    - 🔳 child keyword
                - 🔳 `description`
                    - 🔳 argument
                    - 🔳 child keyword
                - 🔳 `technology`
                    - 🔳 argument
                    - 🔳 child keyword
                - 🔳 `tags`
                    - 🔳 argument
                    - 🔳 child keyword
                - 🔳 `group` (containing components)
                - 🔳 `component`
                    - 🔳 `name`
                        - 🔳 argument
                        - 🔳 child keyword
                    - 🔳 `description`
                        - 🔳 argument
                        - 🔳 child keyword
                    - 🔳 `technology`
                        - 🔳 argument
                        - 🔳 child keyword
                    - 🔳 `tags`
                        - 🔳 argument
                        - 🔳 child keyword
                    - 🔳 `url`
                    - 🔳 `properties`
                    - 🔳 `perspectives`
                    - 🔳 relationships
                - 🔳 `url`
                - 🔳 `properties`
                - 🔳 `perspectives`
                - 🔳 relationships
            - 🔳 `!docs`
            - 🔳 `!adrs`
            - 🔳 `url`
            - 🔳 `properties`
            - 🔳 `perspectives`
            - 🔳 relationships
        - 🔳 `deploymentEnvironment`
            - 🔳 `name` argument
            - 🔳 `deploymentGroup`
                - 🔳 `name` argument
            - 🔳 `deploymentNode`
                - 🔳 `name` argument
                - 🔳 `description`
                    - 🔳 argument
                    - 🔳 child keyword
                - 🔳 `technology`
                    - 🔳 argument
                    - 🔳 child keyword
                - 🔳 `tags`
                    - 🔳 argument
                    - 🔳 child keyword
                - 🔳 `instances`
                    - 🔳 argument
                    - 🔳 child keyword
                - 🔳 `deploymentNode` (nesting)
                - 🔳 `infrastructureNode`
                    - 🔳 `name` argument
                    - 🔳 `description`
                        - 🔳 argument
                        - 🔳 child keyword
                    - 🔳 `technology`
                        - 🔳 argument
                        - 🔳 child keyword
                    - 🔳 `tags`
                        - 🔳 argument
                        - 🔳 child keyword
                    - 🔳 `url`
                    - 🔳 `properties`
                    - 🔳 `perspectives`
                    - 🔳 relationships
                - 🔳 `softwareSystemInstance`
                    - 🔳 `identifier` argument
                    - 🔳 `deploymentGroups` argument
                    - 🔳 `tags`
                        - 🔳 argument
                        - 🔳 child keyword
                    - 🔳 `description` child keyword
                    - 🔳 `description` child keyword
                    - 🔳 `url`
                    - 🔳 `properties`
                    - 🔳 `perspectives`
                    - 🔳 `healthCheck`
                        - 🔳 `name` argument
                        - 🔳 `url` argument
                        - 🔳 `interval` argument
                        - 🔳 `timeout` argument
                    - 🔳 relationships
                - 🔳 `containerInstance`
                    - 🔳 `identifier` argument
                    - 🔳 `deploymentGroups` argument
                    - 🔳 `tags`
                        - 🔳 argument
                        - 🔳 child keyword
                    - 🔳 `description` child keyword
                    - 🔳 `description` child keyword
                    - 🔳 `url`
                    - 🔳 `properties`
                    - 🔳 `perspectives`
                    - 🔳 `healthCheck`
                    - 🔳 relationships
                - 🔳 `url`
                - 🔳 `properties`
                - 🔳 `perspectives`
                - 🔳 relationships
            - 🔳 relationships
        - 🔳 `element`
            - 🔳 `name` argument
            - 🔳 `metadata` argument
            - 🔳 `description`
                - 🔳 argument
                - 🔳 child keyword
            - 🔳 `tags`
                - 🔳 argument
                - 🔳 child keyword
            - 🔳 `url`
            - 🔳 `properties`
            - 🔳 `perspectives`
            - 🔳 relationships
        - 🔳 `enterprise`
            - 🔳 `group`
            - 🔳 `person`
            - 🔳 `softwareSystem`
        - 🔳 relationships
            - 🔳 explicit form
            - 🔳 implicit form
            - 🔳 `description` argument
            - 🔳 `technology` argument
            - 🔳 `tags`
                - 🔳 argument
                - 🔳 child keyword
            - 🔳 `properties`
            - 🔳 `perspectives`
        - 🔳 `!ref`
            - 🔳 `identifier` argument
            - 🔳 `canonical name` argument
    - 🔳 `views`
        - 🔳 `systemLandscape`
        - 🔳 `systemContext`
        - 🔳 `container`
        - 🔳 `component`
        - 🔳 `filtered`
        - 🔳 `dynamic`
        - 🔳 `deployment`
        - 🔳 `custom`
        - 🔳 view definition keywords
            - 🔳 `include`
            - 🔳 `exclude`
            - 🔳 `autoLayout`
            - 🔳 `animation`
            - 🔳 `title`
            - 🔳 `description`
            - 🔳 `properties`
        - 🔳 `styles`
            - 🔳 `element`
                - 🔳 `tag` argument
                - 🔳 `shape`
                - 🔳 `icon`
                - 🔳 `width`
                - 🔳 `height`
                - 🔳 `background`
                - 🔳 `color`
                - 🔳 `colour`
                - 🔳 `stroke`
                - 🔳 `strokeWidth`
                - 🔳 `fontSize`
                - 🔳 `border`
                - 🔳 `opacity`
                - 🔳 `metadata`
                - 🔳 `description`
                - 🔳 `properties`
            - 🔳 `relationship`
                - 🔳 `tag` argument
                - 🔳 `thickness`
                - 🔳 `color`
                - 🔳 `colour`
                - 🔳 `dashed`
                - 🔳 `style`
                - 🔳 `routing`
                - 🔳 `fontSize`
                - 🔳 `width`
                - 🔳 `position`
                - 🔳 `opacity`
                - 🔳 `properties`
        - 🔳 `theme`
            - 🔳 `default` argument
            - 🔳 `url` argument
        - 🔳 `themes`
            - 🔳 `url` argument (multiple)
        - 🔳 `branding`
            - 🔳 `logo`
            - 🔳 `font`
        - 🔳 `terminology`
            - 🔳 `enterprise`
            - 🔳 `person`
            - 🔳 `softwareSystem`
            - 🔳 `container`
            - 🔳 `component`
            - 🔳 `deploymentNode`
            - 🔳 `infrastructureNode`
            - 🔳 `relationship`
        - 🔳 `properties`
        - 🔳 expressions for `include` and `exclude`
    - 🔳 `configuration`
        - 🔳 `users`
            - 🔳 user configuration
        - 🔳 `properties`
