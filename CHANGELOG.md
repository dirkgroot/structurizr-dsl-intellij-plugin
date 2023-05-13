# Structurizr DSL Language Support Changelog

## [Unreleased]

## [0.3.1] - 2023-05-13

### Changed
- Reworked the lexer and parser to be more generic, which should make it a bit easier to support future changes to the
  Structurizr DSL
- Syntax highlighting is now mostly annotator based instead of lexer based

### Added
- Matching curly braces are now highlighted in the editor
- Code can now be commented with the "Comment with line/block comment" commands
- Code is automatically indented correctly while editing

## [0.2.1] - 2023-03-31

### Changed
- Replaced file icon with a generic one (following [this discussion](https://github.com/structurizr/dsl/discussions/240#discussioncomment-5488973)).

## [0.2.0] - 2023-03-31

### Added
- Very simple parser, which should provide just enough of a basis to add basic editor functionality like code formatting and auto indentation.
- Support for IntelliJ's "Reformat Code" command. Currently, this indents blocks and normalizes spacing between tokens on 1 line.

## [0.1.3-alpha] - 2023-03-30

### Changed
- Made the plugin compatible with IntelliJ Platform version 2023.1 (build 231.*).

## [0.1.2-alpha] - 2023-01-09

### Changed
- Only allow "standalone" comments, so one line can either be (part of) a comment (single line of block), or not.
  Comments "embedded" in a regular line of DSL code are not highlighted as comments anymore.
  This fixes [#10](https://github.com/dirkgroot/structurizr-dsl-intellij-plugin/issues/10).

## [0.1.1-alpha] - 2022-12-10

### Changed
- Automatically publish releases from the release GitHub workflow
- Added more information to the README, and the plugin's description

### Fixed
- Syntax highlighting of block comments without a closing `*/`

## [0.1.0-alpha] - 2022-12-08

### Added
- Token based syntax highlighting

[Unreleased]: https://github.com/dirkgroot/structurizr-dsl-intellij-plugin/compare/v0.3.1...HEAD
[0.3.1]: https://github.com/dirkgroot/structurizr-dsl-intellij-plugin/compare/v0.2.1...v0.3.1
[0.2.1]: https://github.com/dirkgroot/structurizr-dsl-intellij-plugin/compare/v0.2.0...v0.2.1
[0.2.0]: https://github.com/dirkgroot/structurizr-dsl-intellij-plugin/compare/v0.1.3-alpha...v0.2.0
[0.1.3-alpha]: https://github.com/dirkgroot/structurizr-dsl-intellij-plugin/compare/v0.1.2-alpha...v0.1.3-alpha
[0.1.2-alpha]: https://github.com/dirkgroot/structurizr-dsl-intellij-plugin/compare/v0.1.1-alpha...v0.1.2-alpha
[0.1.1-alpha]: https://github.com/dirkgroot/structurizr-dsl-intellij-plugin/compare/v0.1.0-alpha...v0.1.1-alpha
[0.1.0-alpha]: https://github.com/dirkgroot/structurizr-dsl-intellij-plugin/commits/v0.1.0-alpha
