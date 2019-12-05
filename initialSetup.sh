#!/bin/bash
set -o nounset -o pipefail -o errexit

chmod 777 reverseproxy/docker-entrypoint.sh

echo "Persistent Storage für Prometheus und Grafana erstellen..."
mkdir -p -m 777 /srv/prometheus/data
mkdir -p -m 777 /srv/grafana/data

UMGEBUNGEN=""

for key in "$@"
do
    case $key in
        -i=*|--image=*)
            UMGEBUNGEN="$UMGEBUNGEN ${key#*=}"
            shift
            ;;
        *)
            echo "Unknown parameter $key"
            exit 1;
            ;;
    esac
done

if [ -z "$UMGEBUNGEN" ]; then
    UMGEBUNGEN="prometheus reverseproxy frontend prim fibonacci"
fi
for UMGEBUNG in $UMGEBUNGEN;
do
    if [ ${UMGEBUNG} = "prometheus" ]; then
        echo "Docker-Image für Prometheus erstellen..."
        docker build -t prometheus:latest Prometheus
    elif [ ${UMGEBUNG} = "reverseproxy" ]; then
        echo "Docker-Image für Reverseproxy erstellen..."
        docker build -t reverseproxy:latest reverseproxy
    elif [ ${UMGEBUNG} = "frontend" ]; then
        echo "Docker-Image für Frontend erstellen..."
        docker build -t frontend:latest Frontend
    elif [ ${UMGEBUNG} = "prim" ]; then	
        echo "Docker-Image für Backend-Primzahlen erstellen..."
        cd Backend-Primzahlen
        mvn clean install
        cd ..
    elif [ ${UMGEBUNG} = "fibonacci" ]; then
        echo "Docker-Image für Backend-Fibonacci erstellen..."
        cd Backend-Fibonacci
        mvn clean install
        cd ..
    else
	echo
        echo "ERROR: ${UMGEBUNG} ist kein Image"
        echo
        exit 1
    fi
done
echo
echo "Die Umgebung kann mit \"docker-compose up\" gestartet werden"
