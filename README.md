# Metriken in Microservice Architektur

----
Im Rahmen meiner Bachelorarbeit habe ich mit mit dem Thema "Metriken zur Überwachung von Betriebsdaten und Nutzungscharakteristiken für Microservice Architekturen" beschäftigt. Im Zuge dieser Arbeit wurden verschiedene Metriken für ein Produkt aus einer Firma erstellt. Als Lehrbeispiel soll dieses Projekt dienen, damit man einen kurzen Einblick bekommt, wie Metriken in einer Docker-Umgebung abgefragt werden können.
Das Lehrbeispiel besteht aus 3 Projekten, einem ReverseProxy, Prometheus und Grafana. Zusätzlich kamen *node-exporter* und *cAdvisor* zum Einsatz.
Die drei Projekte:

* Frontend
* Backend-Fibonacci
* Backend-Primzahlen

sind nur dazu da bestimmte Metriken und Last auf den Containern zu erzeugen. Die beiden Backends sind in [Spring-Boot] geschrieben, das Frontend mit [Angular].

----

## Vorraussetzungen

<img src="https://images.vogel.de/vogelonline/bdb/1115400/1115428/39.jpg" width="100">

* Eine eingerichtete Docker-Umgebung, siehe folgende Installations-Anleitung [Centos-Docker], [Debian-Docker], [Fedora-Docker], [Ubuntu-Docker]
* Node.js, siehe folgende Installations-Anleitung [NodeJS]
* npm (Node Package Manager), siehe folgende Installations-Anleitung [npm]
* maven, siehe folgende Installataions-Anleitung [maven]

## Installation

Zur Installation muss das Skript **./initalSetup.sh** ausgeführt werden.
Mit **-i=** können die Projekte ausgesucht werden, für die ein neues Docker-Image gebaut werden soll. Folgende stehen zur Verfügung:

* reverseproxy
* frontend
* prim
* fibonacci
* prometheus

Wenn kein Projekt angegeben wird, werden alle Docker-Images neu gebaut.

#### Beispiele:

Alle Docker-Images neu bauen:
```
sudo ./initialSetup.sh
```

Prometheus-Image neu bauen:
```
sudo ./initialSetup.sh -i=prometheus
```

Image für beide Backends neu bauen:
```
sudo ./initialSetup.sh -i=prim -i=fibonacci
```

## Starte Umgebung

Um die Umgebung zu starten muss nur der Befehl **docker-compose up** im Main Directory ausgeführt werden.

## Umgang mit Frontend und Grafana

Auf das Frontend kann über **localhost** zugegegriffen werden. Dort können Primzahlen und Fibonaccizahlen bis zu einem eingegeben Limit berechnet werden. Die Berechnung übernehmen die jeweiligen Backend Services.
Über **localhost:9090** kann auf die Prometheus Oberfläche zugegriffen werden.

Für das Beispiel wurde ein Grafana Dashboard bereits angelegt.
Grafana erreicht man mit **localhost:3000**, als Data Source muss hier Prometheus ausgewählt werden. Dafür muss nur die *URL* auf **http://prometheus:9090** gesetzt werden. Anschließend kann ein neues Dashboard [importiert] werden. Dafür die **dashboard.json** importieren (Schaltfläche *Upload .json file* in Grafana)
 

[Centos-Docker]: https://docs.docker.com/install/linux/docker-ce/centos/
[Debian-Docker]: https://docs.docker.com/install/linux/docker-ce/debian/
[Fedora-Docker]: https://docs.docker.com/install/linux/docker-ce/fedora/
[Ubuntu-Docker]: https://docs.docker.com/install/linux/docker-ce/ubuntu/

[NodeJS]: https://github.com/nodesource/distributions/blob/master/README.md

[npm]: https://www.npmjs.com/get-npm
[maven]: https://maven.apache.org/install.html

[importiert]: http://localhost:3000/dashboard/import

[Spring-Boot]: https://spring.io/projects/spring-boot

[Angular]: https://angular.io/

