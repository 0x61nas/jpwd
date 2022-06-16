## jpwd: A modern alternative to GNU/pwd using Java 🥰☕

[![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=Anas-Elgarhy_jpwd&metric=security_rating)](https://sonarcloud.io/summary/new_code?id=Anas-Elgarhy_jpwd)
[![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=Anas-Elgarhy_jpwd&metric=ncloc)](https://sonarcloud.io/summary/new_code?id=Anas-Elgarhy_jpwd)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=Anas-Elgarhy_jpwd&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=Anas-Elgarhy_jpwd)
[![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=Anas-Elgarhy_jpwd&metric=reliability_rating)](https://sonarcloud.io/summary/new_code?id=Anas-Elgarhy_jpwd)
[![Duplicated Lines (%)](https://sonarcloud.io/api/project_badges/measure?project=Anas-Elgarhy_jpwd&metric=duplicated_lines_density)](https://sonarcloud.io/summary/new_code?id=Anas-Elgarhy_jpwd)
[![Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=Anas-Elgarhy_jpwd&metric=vulnerabilities)](https://sonarcloud.io/summary/new_code?id=Anas-Elgarhy_jpwd)[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=Anas-Elgarhy_jpwd&metric=bugs)](https://sonarcloud.io/summary/new_code?id=Anas-Elgarhy_jpwd)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=Anas-Elgarhy_jpwd&metric=code_smells)](https://sonarcloud.io/summary/new_code?id=Anas-Elgarhy_jpwd)

![jpwd screenshot](./screenshots/0.0.1.png "jpwd")

- Requires jdk 17+ and [nerd-fonts](https://www.nerdfonts.com)

### Features
- Colorful output
- Customizable colors for directories names and separator
- Customizable separator
- Supports multiple separators
- Supports icons for directories
- Supports no icons and no colors modes
- Cross-platform (macOS, Windows, Linux) 🌍

### Options table
| Option                       | Value                                                                 | Description                                                                                                                                          |
|------------------------------|-----------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------|
 | `-h` or `--help`             | n/a                                                                   | Show the help message                                                                                                                                |
| `-v` or `--version`          | n/a                                                                   | Show the version                                                                                                                                     |
 | `-s` or `--separator`        | Separator string                                                      | Set the separator (like '-'), accept strings and characters, default is system separator (like '\' in windows or '/' in linux and unix like systems) |
 | `-sc` or `--separator-color` | Color name or hex value, e.g `red` or `#ff000000                      | Set the separator color, accept strings and colors, default is random color                                                                          |
 | `-nc` or `--no-colors`       | n/a                                                                   | Disable colors                                                                                                                                       |
 | `-b` or `--background`       | Color name or hex value, e.g `red` or `#ff000000                      | Set the background color, accept strings and colors, default is none                                                                                 |
 | `-ni` or `--no-icons`        | n/a                                                                   | Disable icons                                                                                                                                        |
 | `-bc` or `--block-colors`    | Block colors list like `red,green,blue` or `#ff000000,#00ff0000`      | Set a list of dont use colors                                                                                                                        |
 | `-cl` or `--colors-list`     | List of allowed colors like `red,green,blue` or `#ff000000,#00ff0000` | Set a list of colors, like "#5f44a4,red" If you use this option, it means that you have blocked all colors except for the ones you passed.           |

## Requirements for development:
- [nerd-font](https://www.nerdfonts.com)
- Maven
- jdk 17
- IntelliJ IDEA (not required but recommended)

## TODO
- [ ] Add Tests
- [ ] Add Formatter
- [ ] Crete arch package
- [ ] Create debian package
- [ ] Add `-L` and `-P` options like the original pwd

### Available in 

[![GitHub](https://img.shields.io/badge/GitHub-Main%20repo-brightgreen?style=for-the-badge&logo=GitHub)](https://github.com/Anas-Elgarhy/jpwd)
[![GitLab](https://img.shields.io/badge/GitLab-Mirror%20repo-brightgreen?style=for-the-badge&logo=GitLab)](https://gitlab.com/java-utils1/jpwd)
[![BitBucket](https://img.shields.io/badge/BitBucket-Mirror%20repo-brightgreen?style=for-the-badge&logo=BitBucket)](https://bitbucket.org/anas_elgarhy/jpwd)
[![Codeberg](https://img.shields.io/badge/Codeberg-Mirror%20repo-brightgreen?style=for-the-badge&logo=Codeberg)](https://codeberg.org/java-utils/jpwd)


[![Quality gate](https://sonarcloud.io/api/project_badges/quality_gate?project=Anas-Elgarhy_jpwd)](https://sonarcloud.io/summary/new_code?id=Anas-Elgarhy_jpwd)


[![SonarCloud](https://sonarcloud.io/images/project_badges/sonarcloud-black.svg)](https://sonarcloud.io/summary/new_code?id=Anas-Elgarhy_jpwd)

![License: GPL-3.0](https://img.shields.io/badge/License-GPL%203.0-blue.svg)