# Structurizr DSL Language Support Changelog

## [Unreleased]

## [0.3.7] - 2024-09-21

- Upgrade the IntelliJ Platform Gradle Plugin
- Removed the upper bound on plugin compatibility

## [0.3.6] - 2024-08-08

- Made the plugin compatible with IntelliJ 2024.2

## [0.3.5] - 2024-04-04

- Made the plugin compatible with IntelliJ 2024.1

## [0.3.4] - 2024-01-10

### Fixed

- Allow line and block comments inside `properties`, `perspectives` and `users` blocks
- Parser error when using unquoted arguments containing curly braces (fixes #58)
- Highlighting/indentation of parallel sequences (fixes #70)

## [0.3.3] - 2023-12-29

- Made the plugin compatible with IntelliJ 2023.3 (fixes #103)

## [0.3.2] - 2023-08-03

### Added

- Blocks delimited by `{` and `}` can now be collapsed

### Changed

- Made parsing property blocks more permissive, so they will always be highlighted as property blocks, regardless of
  whether a property definition is complete
- Made the plugin compatible with IntelliJ 2023.2 (fixes #78)

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

[Unreleased]: https://github.com/dirkgroot/structurizr-dsl-intellij-plugin/compare/v0.3.7...HEAD
[0.3.7]: https://github.com/dirkgroot/structurizr-dsl-intellij-plugin/compare/v0.3.6...v0.3.7
[0.3.6]: https://github.com/dirkgroot/structurizr-dsl-intellij-plugin/compare/v0.3.5...v0.3.6
[0.3.5]: https://github.com/dirkgroot/structurizr-dsl-intellij-plugin/compare/v0.3.4...v0.3.5
[0.3.4]: https://github.com/dirkgroot/structurizr-dsl-intellij-plugin/compare/v0.3.3...v0.3.4
[0.3.3]: https://github.com/dirkgroot/structurizr-dsl-intellij-plugin/compare/v0.3.2...v0.3.3
[0.3.2]: https://github.com/dirkgroot/structurizr-dsl-intellij-plugin/compare/v0.3.1...v0.3.2
[0.3.1]: https://github.com/dirkgroot/structurizr-dsl-intellij-plugin/compare/v0.2.1...v0.3.1
[0.2.1]: https://github.com/dirkgroot/structurizr-dsl-intellij-plugin/compare/v0.2.0...v0.2.1
[0.2.0]: https://github.com/dirkgroot/structurizr-dsl-intellij-plugin/compare/v0.1.3-alpha...v0.2.0
[0.1.3-alpha]: https://github.com/dirkgroot/structurizr-dsl-intellij-plugin/compare/v0.1.2-alpha...v0.1.3-alpha
[0.1.2-alpha]: https://github.com/dirkgroot/structurizr-dsl-intellij-plugin/compare/v0.1.1-alpha...v0.1.2-alpha
[0.1.1-alpha]: https://github.com/dirkgroot/structurizr-dsl-intellij-plugin/compare/v0.1.0-alpha...v0.1.1-alpha
[0.1.0-alpha]: https://github.com/dirkgroot/structurizr-dsl-intellij-plugin/commits/v0.1.0-alpha
