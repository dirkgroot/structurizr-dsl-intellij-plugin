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
<!-- TOC -->

# IntelliJ plugin for the Structurizr DSL

<!-- Plugin description -->

Adds [Structurizr DSL](https://github.com/structurizr/dsl/blob/master/docs/language-reference.md) language support to
IntelliJ.

Structurizr DSL is a domain specific language for creating architecture models and diagrams
using [Simon Brown](https://twitter.com/simonbrown)'s [C4 model](https://c4model.com).

> **Note**
>
> This plugin is a **work in progress**! There may be bugs, and features that you might expect from a language plugin
> are missing. I'd love to get your feedback! You can leave feedback
> by [writing a review](https://plugins.jetbrains.com/plugin/20606-structurizr-dsl-language-support/reviews) or
> by [filing an issue](https://github.com/dirkgroot/structurizr-dsl-intellij-plugin/issues).

## Features

* Basic syntax highlighting for the Structurizr DSL language. Files with the `.dsl` extension are considered to be
  Structurizr DSL files.
* Automatically indent and normalize spacing with IntelliJ's "Reformat Code" command.
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

Search for "Structurizr" in the marketplace, and install the plugin. Please refer to IntelliJ's
[documentation](https://www.jetbrains.com/help/idea/managing-plugins.html) for instructions on how to install plugins.

## TODO

### Legend

- 🔳 = todo
- ☑️ = partially done
- ✅ = done

### Features

- ☑️ syntax highlighting
  - ✅ token based
  - 🔳 annotator based
- ✅ reformat code
- 🔳 auto indentation
- 🔳 go to definition
- 🔳 rename refactoring for identifiers
- 🔳 code validation
- 🔳 code completion
- 🔳 quick documentation
- 🔳 diagram preview
- ...
