# Structurizr DSL Language Support Changelog

## [Unreleased]

### Changed
- Only allow "standalone" comments, so one line can either be (part of) a comment (single line of block), or not.
  Comments "embedded" in a regular line of DSL code are not highlighted as comments anymore. This fixes #10.

## [0.1.1-alpha] - 2022-12-10

### Changed
- Automatically publish releases from the release GitHub workflow
- Added more information to the README, and the plugin's description

### Fixed
- Syntax highlighting of block comments without a closing `*/`

## [0.1.0-alpha] - 2022-12-08

### Added
- Token based syntax highlighting

[Unreleased]: https://github.com/dirkgroot/structurizr-dsl-intellij-plugin/compare/v0.1.1-alpha...HEAD
[0.1.1-alpha]: https://github.com/dirkgroot/structurizr-dsl-intellij-plugin/compare/v0.1.0-alpha...v0.1.1-alpha
[0.1.0-alpha]: https://github.com/dirkgroot/structurizr-dsl-intellij-plugin/commits/v0.1.0-alpha
