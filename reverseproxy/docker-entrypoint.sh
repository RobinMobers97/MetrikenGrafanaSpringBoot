#!/bin/sh

NGINX_CONFIG_FILE="/etc/nginx/conf.d/backend.conf"
RESOLVER_COMMAND_PATTERN="^\s*resolver\s+"

if [ ! -f "${NGINX_CONFIG_FILE}" ]
then
    echo "WARN: nginx config file '${NGINX_CONFIG_FILE}' not found, nothing will be changed"
else
    if [ -z "${DOCKER_RESOLVER}" ]
    then
        echo "INFO: Environment variable is not set, using default"
        DOCKER_RESOLVER="127.0.0.11"
    fi

    # search for "resolver" command in config file and replace nameservers with content of variable
    sed -i -E "s/(${RESOLVER_COMMAND_PATTERN})[^=]+(\s+\w+=.+)?;/\1${DOCKER_RESOLVER}\2; ## nameserver set by startup script/" "${NGINX_CONFIG_FILE}"

    RC=$?
    if [ $RC -gt 0 ]
    then
        echo "ERROR: Error while trying to change nameserver for 'resolver' command"
    fi
fi

exec "$@"

