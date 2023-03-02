[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![License][license-shield]][license-url]

# Spring Cloud Gateway and GraalVM native image example

[![arm64-native](https://circleci.com/gh/dashaun/dev.dashaun.service.gateway.svg?style=shield)](https://app.circleci.com/pipelines/github/dashaun/dev.dashaun.service.gateway) |
[![amd64-native](https://github.com/dashaun/dev.dashaun.service.gateway/actions/workflows/amd64-native.yml/badge.svg)](https://github.com/dashaun/dev.dashaun.service.gateway/actions/workflows/amd64-native.yml)

- [Spring Boot Gateway](https://spring.io/projects/spring-cloud-gateway)
- [Spring Cloud 2022.0.0-RC2](https://spring.io/projects/spring-cloud)
- [Spring Boot 3.0.0](https://spring.io/projects/spring-boot)
- [Testcontainers](https://testcontainers.org)

## | [Prerequisites](#prerequisites) | [Quick Start](#quick-start) | [Build Native Image](#build-native-image) | [Native Image Test](#native-image-test) | [See Also](#see-also) | [Contributing](#contributing) | [License](#license) |

## Prerequisites

- Java 17 or above
- [GraalVM](https://graalvm.org) 22.3 or above

## Quick Start

```bash
git clone https://github.com/dashaun/dev.dashaun.service.gateway
cd dev.dashaun.service.gateway
./gradlew bootRun
```

## Build Native Image

```bash
./gradlew bootBuildImage
```

## Native Image Test

Uses [Testcontainers](https://testcontainers.org) to build a `native` image with [GraalVM](https://graalvm.org), and run tests against it.

```bash
./gradlew integrationTest
```

## Multi-architecture buildpack

This repository uses [dashaun/java-native-builder-multiarch:7.4.1](https://hub.docker.com/r/dashaun/java-native-builder-multiarch)
which allows you to create `native` images for both AMD64 and ARM64 architectures.
I'm trying to take the `ARM64` support upstream to [Paketo](https://paketo.io), so any feedback you have from using this buildpack, with this project or any other is greatly appreciated!

## See Also

- [Spring Cloud Gateway 4.0.0-rc2 native example with Testcontainers](https://dashaun.com/posts/spring-cloud-gateway-4-0-0-rc2-native-example-with-testcontainers/)
- [Cloud Native Buildpack for ARM64 and AMD64](https://dashaun.com/posts/java-native-builder-multiarch-7-41-0/)
- [First attempt at a multi-architecture buildpack](https://dashaun.com/posts/multiarch-builder-poc/)
- [K3s Knative Ubuntu Raspberry Pi](https://dashaun.com/posts/k3s-knative-ubuntu-raspberry-pi/)

<!-- CONTRIBUTING -->
## Contributing

### Release

- git tag v#.#.#
- git push origin v#.#.#

Pull-requests are welcomed!

<!-- LICENSE -->
## License

Distributed under the Apache License, Version 2.0. See `LICENSE` for more information.

<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/dashaun/dev.dashaun.service.gateway.svg?style=for-the-badge
[contributors-url]: https://github.com/dashaun/dev.dashaun.service.gateway/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/dashaun/dev.dashaun.service.gateway.svg?style=for-the-badge
[forks-url]: https://github.com/dashaun/dev.dashaun.service.gateway/network/members
[stars-shield]: https://img.shields.io/github/stars/dashaun/dev.dashaun.service.gateway.svg?style=for-the-badge
[stars-url]: https://github.com/dashaun/dev.dashaun.service.gateway/stargazers
[issues-shield]: https://img.shields.io/github/issues/dashaun/dev.dashaun.service.gateway.svg?style=for-the-badge
[issues-url]: https://github.com/dashaun/dev.dashaun.service.gateway/issues
[license-shield]: https://img.shields.io/github/license/dashaun/dev.dashaun.service.gateway.svg?style=for-the-badge
[license-url]: https://github.com/dashaun/dev.dashaun.service.gateway/blob/master/LICENSE.txt
